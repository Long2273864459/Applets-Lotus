package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.system.service.ITeacherCounselorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Prock.Liy
 * @Date 2021/3/13 20:54
 * @Descripttion  师资Api
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "teacher")
public class TeacherCounselorController {

    @Resource
    private ITeacherCounselorService iTeacherCounselorService;

    @PostMapping("counselor")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    @ResponseBody
    public FebsResponse list() {
        return new FebsResponse().success().data(iTeacherCounselorService.teacherCounselor());
    }
}
