package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.Course;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.mapper.CourseMapper;
import cc.mrbird.febs.system.mapper.UserMapper;
import cc.mrbird.febs.system.service.ICourseService;
import cc.mrbird.febs.system.service.IExcellentCourseService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
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

    @Override
    public JSONObject findCourseList() {
        JSONObject counselorObject = new JSONObject();
        try {
            counselorObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            counselorObject.put("courseTop","http://8.136.200.209:8081/pictures/lunbotu2.jpg");
            counselorObject.put("courseList",baseMapper.findCourseList());
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return counselorObject;
    }

    @Override
    public JSONObject findCourseDetail(Long code) {
        JSONObject counselorObject = new JSONObject();
        try {
            counselorObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            counselorObject.put("courseTop","http://8.136.200.209:8081/pictures/lunbotu2.jpg");
            counselorObject.put("course",baseMapper.findCourseDetail(code));
            counselorObject.put("courseBottom","http://8.136.200.209:8081/pictures/20210311145206.jpg");
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return counselorObject;
    }

    @Override
    public JSONObject findTeens() {
        JSONObject teensObject = new JSONObject();
        try {
            teensObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            teensObject.put("courseTopOne","http://8.136.200.209:8081/pictures/qsnyqkc2.jpg");
            teensObject.put("courseTopTwo","http://8.136.200.209:8081/pictures/qsnyjkc3.jpg");
            teensObject.put("leaderImage","http://8.136.200.209:8081/pictures/wllxxxk.jpg");
            teensObject.put("qiaImage","http://8.136.200.209:8081/pictures/qtxcgz.jpg.jpg");
            teensObject.put("futureImage","http://8.136.200.209:8081/pictures/wllxcgz.jpg");
            teensObject.put("courseBottom","http://8.136.200.209:8081/pictures/20210311145206.jpg");
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return teensObject;
    }

    @Override
    public JSONObject findStudentStyle() {
        JSONObject studentStyleObject = new JSONObject();
        try {
            studentStyleObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            studentStyleObject.put("imageOne","http://8.136.200.209:8081/pictures/lhys1.jpg.jpg");
            studentStyleObject.put("imageTwo","http://8.136.200.209:8081/pictures/lhys2.jpg");
            studentStyleObject.put("imageThree","http://8.136.200.209:8081/pictures/lhys3.jpg");
            studentStyleObject.put("imageFour","http://8.136.200.209:8081/pictures/lhys4.jpg");
            studentStyleObject.put("imageFives","http://8.136.200.209:8081/pictures/lhys5.jpg");
            studentStyleObject.put("imageSix","http://8.136.200.209:8081/pictures/lhys6.jpg.jpg");
            studentStyleObject.put("imageSeven","http://8.136.200.209:8081/pictures/lhys7.jpg");
            studentStyleObject.put("imageEight","http://8.136.200.209:8081/pictures/lhys8.jpg");
            studentStyleObject.put("imageNine","http://8.136.200.209:8081/pictures/lhys9.jpg");
            studentStyleObject.put("imageTen","http://8.136.200.209:8081/pictures/lhys10.jpg");
            studentStyleObject.put("imageEleven","http://8.136.200.209:8081/pictures/lhys11.jpg");
            studentStyleObject.put("courseBottom","http://8.136.200.209:8081/pictures/20210311145206.jpg");
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return studentStyleObject;
    }

    @Override
    public JSONObject findAboutLotus() {
        JSONObject aboutLotusObject = new JSONObject();
        try {
            aboutLotusObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            aboutLotusObject.put("aboutLotusImage","http://8.136.200.209:8081/pictures/gunayulianhua1.jpg");
            aboutLotusObject.put("courseBottom","http://8.136.200.209:8081/pictures/20210311145206.jpg");
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return aboutLotusObject;
    }
}
