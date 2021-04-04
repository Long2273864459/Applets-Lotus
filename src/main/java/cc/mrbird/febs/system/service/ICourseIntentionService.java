package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.dto.CourseIntentionResponseDTO;
import cc.mrbird.febs.system.entity.CourseIntention;
import cc.mrbird.febs.system.dto.CourseIntentionRequestDTO;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
     * @param courseIntentionRequestDTO
     * @return
     */
    boolean addCourseIntention(CourseIntentionRequestDTO courseIntentionRequestDTO);

    /**
     * 查询当前用户预约的课程列表
     * @param userId
     * @return JSONObject
     */
    List<CourseIntentionResponseDTO> findListByUserId(Long userId);

    /**
     * 删除
     * @param code code
     */
    void deleteCourseIntention(Long code);
}
