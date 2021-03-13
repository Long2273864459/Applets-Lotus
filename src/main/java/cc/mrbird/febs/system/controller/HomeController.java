package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.FebsResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author Prock.Liy
 * @Date 2021/3/13 20:54
 * @Descripttion  首页Api
 * @Version 1.0
 */
@RestController
@RequestMapping("home")
public class HomeController {

    @PostMapping("homePage")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse test() throws IOException {

        return new FebsResponse().success();
    }
}
