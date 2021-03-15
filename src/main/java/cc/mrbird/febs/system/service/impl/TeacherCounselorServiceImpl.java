package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.TeacherCounselor;
import cc.mrbird.febs.system.mapper.TeacherCounselorMapper;
import cc.mrbird.febs.system.service.ITeacherCounselorService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Prock.Liy
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeacherCounselorServiceImpl extends ServiceImpl<TeacherCounselorMapper, TeacherCounselor> implements ITeacherCounselorService {

    @Override
    public List<TeacherCounselor> teacherCounselorList() {
        return baseMapper.findTeacherCounselorList();
    }

    @Override
    public JSONObject homePage() {
        JSONObject homePageObject = new JSONObject();
        try {
            homePageObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            List<String> carouselList = new ArrayList<>();
            carouselList.add("http://8.136.200.209:8081/pictures/lunbotu1.png");
            carouselList.add("http://8.136.200.209:8081/pictures/lunbotu2.jpg");
            carouselList.add("http://8.136.200.209:8081/pictures/lunbotu3.jpg");
            homePageObject.put("carouse",carouselList);
            homePageObject.put("homePictureOne","http://8.136.200.209:8081/pictures/shouye1.jpg");
            homePageObject.put("homePictureTwo","http://8.136.200.209:8081/pictures/shouye2.jpg");
            homePageObject.put("homePictureThree","http://8.136.200.209:8081/pictures/shouye3.jpg");
            homePageObject.put("confusedList",confused());
            homePageObject.put("areaList",area());
            homePageObject.put("homePictureFour","http://8.136.200.209:8081/pictures/shouye4.jpg");
            homePageObject.put("homePictureFives","http://8.136.200.209:8081/pictures/shouye5.jpg");

            homePageObject.put("homePictureSix","http://8.136.200.209:8081/pictures/shouye6.jpg");
            Map<String,String> courseOne = new HashMap<>(1);
            courseOne.put("《总裁演讲突破班》","克服恐惧，提升演讲自信，如何进行会议总结。年会，招商会等事业场景演讲。如何介绍公司，产品，团队，项目");
            homePageObject.put("homeTextSix",courseOne);

            homePageObject.put("homePictureSeven","http://8.136.200.209:8081/pictures/shouye7.jpg");
            Map<String,String> courseTwo = new HashMap<>(1);
            courseTwo.put("《演讲改变人生》","1.会演讲有什么用2.演讲为什么紧张忘词3.如何练就魅力桑音4.如何发表营销演讲？5.如何.....");
            homePageObject.put("homeTextSeven",courseTwo);

            homePageObject.put("homePictureEight","http://8.136.200.209:8081/pictures/shouye8.jpg");
            Map<String,String> courseEight = new HashMap<>(1);
            courseEight.put("《青少年演讲口才》","1.提高演讲咨询2.增强语言表达能力3.知感恩，懂卑谦4.有耐心，善坚持5.遇事学会沟通");
            homePageObject.put("homeTextEight",courseEight);

            homePageObject.put("teacherCounselor",this.teacherCounselorList());
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return homePageObject;
    }

    @Override
    public JSONObject teacherCounselor() {
        JSONObject teacherCounselorObject = new JSONObject();
        try {
            teacherCounselorObject.put("topImages","http://8.136.200.209:8081/pictures/lianhua.png");
            List<String> carouselList = new ArrayList<>();
            carouselList.add("http://8.136.200.209:8081/pictures/lunbotu1.png");
            carouselList.add("http://8.136.200.209:8081/pictures/lunbotu2.jpg");
            carouselList.add("http://8.136.200.209:8081/pictures/lunbotu3.jpg");
            teacherCounselorObject.put("carouse",carouselList);
            teacherCounselorObject.put("teacherCounselor",this.teacherCounselorList());
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return teacherCounselorObject;
    }

    /**
     * 困惑点集合调用
     * @return
     */
    public static List<String> confused(){
        List<String> confusedList = new ArrayList<>();
        confusedList.add("上台紧张怯场忘词");
        confusedList.add("上台发言没话说");
        confusedList.add("上台发言没条理");
        confusedList.add("上台发言没重点");
        confusedList.add("演讲缺少感染力");
        confusedList.add("演讲缺少营销力");
        confusedList.add("演讲没有说服力");
        confusedList.add("演讲没有领导影响力");
        return confusedList;
    }

    /**
     * 困惑点集合调用
     * @return
     */
    public static List<String> area(){
        List<String> areaList = new ArrayList<>();
        areaList.add("广州");
        areaList.add("深圳");
        areaList.add("珠海");
        areaList.add("上海");
        areaList.add("杭州");
        areaList.add("郑州");
        areaList.add("济南");
        areaList.add("长沙");
        return areaList;
    }
}
