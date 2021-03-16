package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.CourseIntention;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
