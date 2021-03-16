package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.system.entity.ExcellentCourse;
import cc.mrbird.febs.system.service.IExcellentCourseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author Prock.Liy
 * @Date 2021/3/13 20:54
 * @Descripttion  精品课程Api
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "excellent")
public class ExcellentCourseController {

    @Resource
    private IExcellentCourseService iExcellentCourseService;

    @PostMapping("course/list")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse list(@RequestBody @Valid JSONObject jsonObject) {
        String sort = jsonObject.getString("sort");
        String keyWord = jsonObject.getString("keyWord");
        return new FebsResponse().success().data(iExcellentCourseService.findExcellentCourseList(sort,keyWord));
    }

    @GetMapping("course/{code}")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse Detail(@PathVariable("code") Long code) {
        return new FebsResponse().success().data(iExcellentCourseService.findExcellentCourseDetail(code));
    }

    @PostMapping("course/add")
    @ControllerEndpoint(operation = "新增出错", exceptionMessage = "请求资源出错")
    public FebsResponse add(@RequestBody @Valid ExcellentCourse excellentCourse) {
        iExcellentCourseService.addExcellentCourse(excellentCourse);
        return new FebsResponse().success();
    }
}
