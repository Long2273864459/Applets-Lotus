package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.CourseIntention;
import cc.mrbird.febs.system.entity.CourseIntentionDTO;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Prock.Liy
 */
public interface ICourseIntentionService extends IService<CourseIntention> {

    /**
     * 预约课程列表
     * @return
     */
    JSONObject findCourseIntentionList();

    /**
     * 预约课程
     * @param courseIntention
     * @return
     */
    boolean addCourseIntention(CourseIntentionDTO courseIntentionDTO);
}
