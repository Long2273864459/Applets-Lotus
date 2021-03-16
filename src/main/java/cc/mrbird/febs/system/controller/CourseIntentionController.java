package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.CourseIntention;
import cc.mrbird.febs.system.entity.CourseIntentionDTO;
import cc.mrbird.febs.system.service.ICourseIntentionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Prock.Liy
 * @Date 2021/3/13 20:54
 * @Descripttion  预约课程Api
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "intention")
public class CourseIntentionController {

    @Resource
    private ICourseIntentionService iCourseIntentionService;

    @PostMapping("list")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse list() {
        return new FebsResponse().success().data(iCourseIntentionService.findCourseIntentionList());
    }

    @PostMapping("add")
    @ControllerEndpoint(operation = "预约出错", exceptionMessage = "预约课程出错")
    public FebsResponse add(@RequestBody @Valid CourseIntentionDTO courseIntentionDTO) {
        // 编译正则表达式
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        // 创建给定输入模式的匹配器
        Matcher matcher = pattern.matcher(courseIntentionDTO.getMobile());
        boolean bool = matcher.matches();
        if(!bool) {
            throw new FebsException("请输入正确的手机号码!");
        }
        iCourseIntentionService.addCourseIntention(courseIntentionDTO);
        return new FebsResponse().success();
    }

}
