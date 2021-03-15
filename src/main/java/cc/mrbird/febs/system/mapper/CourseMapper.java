package cc.mrbird.febs.system.mapper;


import cc.mrbird.febs.system.entity.Course;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程表 Mapper
 *
 * @author Prock.Liy
 * @date 2021-03-13 23:35:20
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 课程列表
     *
     * @return List<Course>
     */
    List<Course> findCourseList();


    /**
     * 课程详情
     */
    Course findCourseDetail(@Param("code") Long code);
}
