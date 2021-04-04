package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.Limit;
import cc.mrbird.febs.common.authentication.ShiroRealm;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.service.ValidateCodeService;
import cc.mrbird.febs.common.utils.Md5Util;
import cc.mrbird.febs.monitor.service.ILoginLogService;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @author MrBird
 */
@Validated
@RestController
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final IUserService userService;
    private final ValidateCodeService validateCodeService;
    private final ILoginLogService loginLogService;

    @Resource
    private ShiroRealm shiroRealm;

    @PostMapping("login")
    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public FebsResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            boolean rememberMe) throws FebsException {
        User user = userService.findByName(username);
        if (Objects.isNull(user)) {
            throw new FebsException("该用户名不存在,请先注册!");
        }
        user.setPLAIN(StringUtils.EMPTY);
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                Md5Util.encrypt(username.toLowerCase(), password), rememberMe);
        super.login(token);
        user.setAreaArray(JSONArray.parseArray(user.getArea()));
        user.setArea(StringUtils.EMPTY);
        // 保存登录日志
        loginLogService.saveLoginLog(username);
        return new FebsResponse().success().data(user);
    }

    @PostMapping("register")
    public FebsResponse register(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws FebsException {
        User user = userService.findByName(username);
        if (user != null) {
            throw new FebsException("该用户名已存在");
        }
        userService.register(username, password);
        return new FebsResponse().success();
    }

    @GetMapping("index/{username}")
    public FebsResponse index(@NotBlank(message = "{required}") @PathVariable String username) {
        // 更新登录时间
        userService.updateLoginTime(username);
        // 获取首页数据
        Map<String, Object> data = loginLogService.retrieveIndexPageData(username);
        return new FebsResponse().success().data(data);
    }

    @GetMapping("images/captcha")
    @Limit(key = "get_captcha", period = 60, count = 10, name = "获取验证码", prefix = "limit")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, FebsException {
        validateCodeService.create(request, response);
    }

    /**
     * 系统踢出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public FebsResponse logout() {
        User user = getCurrentUser();
        if (Objects.isNull(user)) {
            throw new FebsException("退出失败,请稍后再试!");
        }
        shiroRealm.clearCache(user.getUserId());
        return new FebsResponse().success();
    }

}
