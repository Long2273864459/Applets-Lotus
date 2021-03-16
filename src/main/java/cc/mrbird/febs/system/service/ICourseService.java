package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.Course;
import com.alibaba.fastjson.JSON;
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

    /**
     * 青少年演讲口才
     * @return
     */
    JSONObject findTeens();

    /**
     * 学员风采
     * @return
     */
    JSONObject findStudentStyle();

    /**
     * 关于莲花
     * @return
     */
    JSONObject findAboutLotus();
}
