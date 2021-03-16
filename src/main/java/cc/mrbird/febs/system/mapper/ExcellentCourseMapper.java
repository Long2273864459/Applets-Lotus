package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.ExcellentCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Prock.Liy
 */
public interface ExcellentCourseMapper extends BaseMapper<ExcellentCourse> {

    /**
     * 精品课程列表
     *
     * @return List<Course>
     */
    List<ExcellentCourse> findExcellentCourseList(@Param("sort")String sort,@Param("keyWord") String keyWord);
}
