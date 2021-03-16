package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.system.service.ICourseService;
import cc.mrbird.febs.system.service.ITeacherCounselorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Prock.Liy
 * @Date 2021/3/13 20:54
 * @Descripttion  课程Api
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Resource
    private ICourseService iCourseService;

    @PostMapping("list")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse list() {
        return new FebsResponse().success().data(iCourseService.findCourseList());
    }

    @GetMapping("detail/{code}")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse Detail(@PathVariable("code") Long code) {
        return new FebsResponse().success().data(iCourseService.findCourseDetail(code));
    }

    @GetMapping("detail/teens")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse teens() {
        return new FebsResponse().success().data(iCourseService.findTeens());
    }

    @GetMapping("detail/studentStyle")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse studentStyle() {
        return new FebsResponse().success().data(iCourseService.findStudentStyle());
    }

    @GetMapping("detail/aboutLotus")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse aboutLotus() {
        return new FebsResponse().success().data(iCourseService.findAboutLotus());
    }
}
