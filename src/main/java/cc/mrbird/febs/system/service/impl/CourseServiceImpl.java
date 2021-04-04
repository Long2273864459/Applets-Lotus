package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.Course;
import cc.mrbird.febs.system.mapper.CourseMapper;
import cc.mrbird.febs.system.service.ICourseService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.extranet.ip}")
    private String extranetIp;

    @Override
    public JSONObject findCourseList() {
        JSONObject counselorObject = new JSONObject();
        try {
            counselorObject.put("courseList", baseMapper.findCourseList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return counselorObject;
    }

    @Override
    public JSONObject findCourseDetail(Long code) {
        JSONObject counselorObject = new JSONObject();
        try {
            Course course = baseMapper.findCourseDetail(code);
            counselorObject.put("course", course);
            counselorObject.put("title", course.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return counselorObject;
    }

    @Override
    public JSONObject findTeens() {
        JSONObject teensObject = new JSONObject();
        try {
            List<String> imagesList = new ArrayList<>();
            imagesList.add("http://" + extranetIp + ":8081/pictures/qsnyqkc2.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/qsnyjkc3.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/wllxxxk.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/qtxcgz.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/wllxcgz.jpg");
            teensObject.put("image", imagesList);
            teensObject.put("title", "青少年演讲口才");
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return teensObject;
    }

    @Override
    public JSONObject findStudentStyle() {
        JSONObject studentStyleObject = new JSONObject();
        try {
            List<String> imagesList = new ArrayList<>();
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys1.jpg.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys2.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys3.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys4.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys5.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys6.jpg.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys7.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys8.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys9.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys10.jpg");
            imagesList.add("http://" + extranetIp + ":8081/pictures/lhys11.jpg");
            studentStyleObject.put("image", imagesList);
            studentStyleObject.put("title", "学员风采-莲花演说");
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return studentStyleObject;
    }

    @Override
    public JSONObject findAboutLotus() {
        JSONObject aboutLotusObject = new JSONObject();
        try {
            List<String> imagesList = new ArrayList<>();
            imagesList.add("http://" + extranetIp + ":8081/pictures/gunayulianhua1.jpg");
            aboutLotusObject.put("image", imagesList);
            aboutLotusObject.put("title", "关于莲花演说");
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return aboutLotusObject;
    }
}
