package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.ExcellentCourse;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Prock.Liy
 */
public interface IExcellentCourseService extends IService<ExcellentCourse> {

    /**
     * 精品课程集合
     */
    JSONObject findExcellentCourseList(String sort,String keyWord);


    /**
     * 精品课程详情
     */
    JSONObject findExcellentCourseDetail(Long code);

    /**
     * 新增精品课程
     * @param excellentCourse
     */
    void addExcellentCourse(ExcellentCourse excellentCourse);

}
