package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.entity.Strings;
import cc.mrbird.febs.common.event.UserAuthenticationUpdatedEventPublisher;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.utils.MailUtil;
import cc.mrbird.febs.common.utils.Md5Util;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.system.entity.*;
import cc.mrbird.febs.system.mapper.UserMapper;
import cc.mrbird.febs.system.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author MrBird
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserAuthenticationUpdatedEventPublisher publisher;
    private final IUserDataPermissionService userDataPermissionService;


    @Override
    public User findByName(String username) {
        return baseMapper.findByName(username);
    }

    @Override
    public IPage<User> findUserDetailList(User user, QueryRequest request) {
        if (StringUtils.isNotBlank(user.getCreateTimeFrom()) &&
                StringUtils.equals(user.getCreateTimeFrom(), user.getCreateTimeTo())) {
            user.setCreateTimeFrom(user.getCreateTimeFrom() + FebsConstant.DAY_START_PATTERN_SUFFIX);
            user.setCreateTimeTo(user.getCreateTimeTo() + FebsConstant.DAY_END_PATTERN_SUFFIX);
        }
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countUserDetail(user));
        SortUtil.handlePageSort(request, page, "userId", FebsConstant.ORDER_ASC, false);
        return baseMapper.findUserDetailPage(page, user);
    }

    @Override
    public User findUserDetailList(String username) {
        User param = new User();
        param.setUsername(username);
        List<User> users = baseMapper.findUserDetail(param);
        return CollectionUtils.isNotEmpty(users) ? users.get(0) : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLoginTime(String username) {
        User user = new User();
        user.setLastLoginTime(new Date());
        baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user) {
        user.setCreateTime(new Date());
        user.setStatus(User.STATUS_VALID);
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setIntegral(User.INTEGRAL_NUM);
        user.setPLAIN(user.getPassword());
        user.setPassword(Md5Util.encrypt(user.getUsername(), user.getPassword()));
        save(user);

        // 保存用户数据权限关联关系
        String[] deptIds = StringUtils.splitByWholeSeparatorPreserveAllTokens("1", Strings.COMMA);
        if (ArrayUtils.isNotEmpty(deptIds)) {
            setUserDataPermissions(user, deptIds);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUsers(String[] userIds) {
        List<String> list = Arrays.asList(userIds);
        // 删除用户
        removeByIds(list);
        // 删除关联数据权限
        userDataPermissionService.deleteByUserIds(userIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user) {
        // 更新用户
        user.setPassword(null);
        user.setUsername(null);
        user.setModifyTime(new Date());
        updateById(user);

        String[] userId = {String.valueOf(user.getUserId())};

        userDataPermissionService.deleteByUserIds(userId);
        String[] deptIds = StringUtils.splitByWholeSeparatorPreserveAllTokens("1", Strings.COMMA);
        if (ArrayUtils.isNotEmpty(deptIds)) {
            setUserDataPermissions(user, deptIds);
        }
        publisher.publishEvent(Sets.newHashSet(user.getUserId()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resetPassword(String[] usernames) {
        Arrays.stream(usernames).forEach(username -> {
            User user = new User();
            user.setPassword(Md5Util.encrypt(username, User.DEFAULT_PASSWORD));
            baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(String username, String password) {
        User user = new User();
        user.setPassword(Md5Util.encrypt(username, password));
        user.setPLAIN(password);
        user.setUsername(username);
        user.setCreateTime(new Date());
        user.setStatus(User.STATUS_VALID);
        user.setAvatar(User.DEFAULT_AVATAR);
        save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(String username, String password) {
        User user = new User();
        user.setPassword(Md5Util.encrypt(username, password));
        user.setPLAIN(password);
        user.setModifyTime(new Date());
        baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }


    @Override
    public String retrievePassword(String userName, String email) {
        User user = baseMapper.findByName(userName);
        if (Objects.isNull(user)){
            throw new FebsException("用户名不存在!");
        }
        if (!email.equals(user.getEmail())){
            throw new FebsException("邮箱地址输入有误!");
        }
        boolean mailBox = MailUtil.sendMailbox(email,"您在小程序中注册的个人信息为：\n"+"用户名:"+userName+"\n密码为:"+user.getPLAIN());
        if (!mailBox){
            throw new FebsException("邮件发送失败，请稍后再试!");
        }
        return "密码已发送至注册邮箱,请查收!";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAvatar(String username, String avatar) {
        User user = new User();
        user.setAvatar(avatar);
        user.setModifyTime(new Date());
        baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTheme(String username, String theme, String isTab) {
        User user = new User();
        user.setModifyTime(new Date());
        baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProfile(User user) {
        user.setUsername(null);
        user.setPassword(null);
        if (isCurrentUser(user.getUserId())) {
            updateById(user);
        } else {
            throw new FebsException("您无权修改别人的账号信息！");
        }
    }

    private void setUserDataPermissions(User user, String[] deptIds) {
        List<UserDataPermission> userDataPermissions = new ArrayList<>();
        Arrays.stream(deptIds).forEach(deptId -> {
            UserDataPermission permission = new UserDataPermission();
            permission.setDeptId(Long.valueOf(deptId));
            permission.setUserId(user.getUserId());
            userDataPermissions.add(permission);
        });
        userDataPermissionService.saveBatch(userDataPermissions);
    }

    private boolean isCurrentUser(Long id) {
        User currentUser = FebsUtil.getCurrentUser();
        return currentUser.getUserId().equals(id);
    }

}
