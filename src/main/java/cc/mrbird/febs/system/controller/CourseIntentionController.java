package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.service.ValidateCodeService;
import cc.mrbird.febs.system.dto.CourseIntentionRequestDTO;
import cc.mrbird.febs.system.service.ICourseIntentionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Prock.Liy
 * @Date 2021/3/13 20:54
 * @Descripttion  预约课程Api
 * @Version 1.0
 */
@Validated
@RestController
@RequestMapping(value = "intention")
@RequiredArgsConstructor
public class CourseIntentionController extends BaseController {

    @Resource
    private ICourseIntentionService iCourseIntentionService;

    private final ValidateCodeService validateCodeService;



    @PostMapping("list")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse list() {
        return new FebsResponse().success().data(iCourseIntentionService.findCourseIntentionList());
    }

    @PostMapping("add")
    @ControllerEndpoint(operation = "预约出错", exceptionMessage = "预约课程出错")
    public FebsResponse add(@RequestBody CourseIntentionRequestDTO courseIntentionRequestDTO, HttpServletRequest request) {
        // 验证码校验
        //validateCodeService.check(request.getSession().getId(), courseIntentionDTO.getVerifyCode());
        // 编译正则表达式
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        // 创建给定输入模式的匹配器
        Matcher matcher = pattern.matcher(courseIntentionRequestDTO.getMobile());
        boolean bool = matcher.matches();
        if(!bool) {
            throw new FebsException("请输入正确的手机号码!");
        }
        iCourseIntentionService.addCourseIntention(courseIntentionRequestDTO);
        return new FebsResponse().success();
    }

    @PostMapping("list/{userId}")
    @ControllerEndpoint(operation = "请求出错", exceptionMessage = "请求资源出错")
    public FebsResponse userList(@PathVariable Long userId) {
        return new FebsResponse().success().data(iCourseIntentionService.findListByUserId(userId));
    }

    @DeleteMapping("delete/{code}")
    public FebsResponse delete(@PathVariable Long code) {
        iCourseIntentionService.deleteCourseIntention(code);
        return new FebsResponse().success();
    }

}
