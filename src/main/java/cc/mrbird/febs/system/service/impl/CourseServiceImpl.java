package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.Course;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.mapper.CourseMapper;
import cc.mrbird.febs.system.mapper.UserMapper;
import cc.mrbird.febs.system.service.ICourseService;
import cc.mrbird.febs.system.service.IExcellentCourseService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prock.Liy
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public JSONObject findCourseList() {
        JSONObject counselorObject = new JSONObject();
        try {
            counselorObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            counselorObject.put("courseTop","http://8.136.200.209:8081/pictures/lunbotu2.jpg");
            counselorObject.put("courseList",baseMapper.findCourseList());
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return counselorObject;
    }

    @Override
    public JSONObject findCourseDetail(Long code) {
        JSONObject counselorObject = new JSONObject();
        try {
            counselorObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            counselorObject.put("courseTop","http://8.136.200.209:8081/pictures/lunbotu2.jpg");
            counselorObject.put("course",baseMapper.findCourseDetail(code));
            counselorObject.put("courseBottom","http://8.136.200.209:8081/pictures/20210311145206.jpg");
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return counselorObject;
    }
}
