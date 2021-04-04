package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.authentication.ShiroRealm;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.entity.Strings;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.Md5Util;
import cc.mrbird.febs.system.dto.UserShippingAddressDTO;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author MrBird
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private ShiroRealm shiroRealm;


    private final IUserService userService;

    @GetMapping("{username}")
    public User getUser(@NotBlank(message = "{required}") @PathVariable String username) {
        return userService.findUserDetailList(username);
    }

    @GetMapping("userDetail/{username}")
    public User userDetail(@NotBlank(message = "{required}") @PathVariable String username) {
        User user = userService.findByName(username);
        user.setAreaArray(JSONArray.parseArray(user.getArea()));
        user.setArea(StringUtils.EMPTY);
        return user;
    }

    @GetMapping("check/{username}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username, String userId) {
        return userService.findByName(username) == null || StringUtils.isNotBlank(userId);
    }

    @GetMapping("list")
    @RequiresPermissions("user:view")
    public FebsResponse userList(User user, QueryRequest request) {
        return new FebsResponse().success()
                .data(getDataTable(userService.findUserDetailList(user, request)));
    }

    @PostMapping("add")
    @ApiImplicitParam(name = "User", value = "user", required = true, paramType = "body", dataType = "JSONObject")
    @ControllerEndpoint(operation = "新增用户", exceptionMessage = "新增用户失败")
    public FebsResponse addUser(@RequestBody @Valid User user) {
        userService.createUser(user);
        return new FebsResponse().success();
    }

    @PostMapping("test")
    public FebsResponse test() {
        return new FebsResponse().success();
    }

    @GetMapping("delete/{userIds}")
    @RequiresPermissions("user:delete")
    @ControllerEndpoint(operation = "删除用户", exceptionMessage = "删除用户失败")
    public FebsResponse deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) {
        userService.deleteUsers(StringUtils.split(userIds, Strings.COMMA));
        return new FebsResponse().success();
    }

    @PostMapping("update")
    @RequiresPermissions("user:update")
    @ControllerEndpoint(operation = "修改用户", exceptionMessage = "修改用户失败")
    public FebsResponse updateUser(@Valid User user) {
        if (user.getUserId() == null) {
            throw new FebsException("用户ID为空");
        }
        userService.updateUser(user);
        return new FebsResponse().success();
    }

    @PostMapping("password/reset/{usernames}")
    @RequiresPermissions("user:password:reset")
    @ControllerEndpoint(exceptionMessage = "重置用户密码失败")
    public FebsResponse resetPassword(@NotBlank(message = "{required}") @PathVariable String usernames) {
        userService.resetPassword(StringUtils.split(usernames, Strings.COMMA));
        return new FebsResponse().success();
    }

    @PostMapping("password/update")
    @ControllerEndpoint(exceptionMessage = "修改密码失败")
    public FebsResponse updatePassword(
            @NotBlank(message = "{required}") String oldPassword,
            @NotBlank(message = "{required}") String newPassword) throws FebsException {
        User user = getCurrentUser();
        if (!StringUtils.equals(user.getPassword(), Md5Util.encrypt(user.getUsername(), oldPassword)))  {
            throw new FebsException("原密码不正确");
        }
        shiroRealm.clearCache(user.getUserId());
        userService.updatePassword(user.getUsername(), newPassword);
        return new FebsResponse().success();
    }

    /**
     * 找回密码
     * @param username
     * @param email
     * @return
     */
    @PostMapping("password/retrieve")
    @ControllerEndpoint(exceptionMessage = "找回密码失败")
    public FebsResponse retrievePassword(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String email) {
        return new FebsResponse().success().data(userService.retrievePassword(username,email));
    }

    @PostMapping("avatar")
    @ControllerEndpoint(exceptionMessage = "修改头像失败")
    public FebsResponse updateAvatar(@RequestParam("file")MultipartFile[] files) {
        if(files!=null && files.length >= 1) {
            for (MultipartFile profile : files){
                userService.updateAvatar(getCurrentUser().getUserId(), profile);
            }
        }
        return new FebsResponse().success();
    }

    @PostMapping("theme/update")
    @ControllerEndpoint(exceptionMessage = "修改系统配置失败")
    public FebsResponse updateTheme(String theme, String isTab) {
        userService.updateTheme(getCurrentUser().getUsername(), theme, isTab);
        return new FebsResponse().success();
    }

    @PostMapping("profile/update")
    @ControllerEndpoint(exceptionMessage = "修改个人信息失败")
    public FebsResponse updateProfile(@RequestBody User user) throws FebsException {
        if (user.getUserId() == User.INTEGRAL_NUM){
            throw new FebsException("请传入userId!");
        }
        userService.updateProfile(user);
        return new FebsResponse().success();
    }

    @PostMapping("shippingAddress")
    @ControllerEndpoint(exceptionMessage = "添加收货地址失败")
    public FebsResponse addShippingAddress(@RequestBody UserShippingAddressDTO userShippingAddressDTO) throws FebsException {
        userService.addShippingAddress(userShippingAddressDTO);
        return new FebsResponse().success();
    }

}
