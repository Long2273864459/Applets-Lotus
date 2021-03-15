package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.Course;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Prock.Liy
 */
public interface ICourseService extends IService<Course> {

    /**
     * 课程集合
     */
    JSONObject findCourseList();


    /**
     * 课程详情
     */
    JSONObject findCourseDetail(Long code);
}
