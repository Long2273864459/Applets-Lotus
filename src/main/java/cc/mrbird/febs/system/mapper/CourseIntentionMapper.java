package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.CourseIntention;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Prock.Liy
 */
public interface CourseIntentionMapper extends BaseMapper<CourseIntention> {

    /**
     * 查询报名总数
     * @return
     */
    Integer findCount();

    List<CourseIntention> findCourseIntentionList();

    /**
     * 查询预约列表
     * @param userId
     * @return
     */
    List<CourseIntention> findListByUserId(@Param("userId") Long userId);
}
