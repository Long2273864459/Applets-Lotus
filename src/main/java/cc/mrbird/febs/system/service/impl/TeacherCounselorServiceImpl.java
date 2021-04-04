package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.TeacherCounselor;
import cc.mrbird.febs.system.mapper.TeacherCounselorMapper;
import cc.mrbird.febs.system.service.ITeacherCounselorService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc.mrbird.febs.common.utils.LotusUtil.area;
import static cc.mrbird.febs.common.utils.LotusUtil.confused;

/**
 * @author Prock.Liy
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeacherCounselorServiceImpl extends ServiceImpl<TeacherCounselorMapper, TeacherCounselor> implements ITeacherCounselorService {

    @Value("${spring.extranet.ip}")
    private String extranetIp;

    @Override
    public List<TeacherCounselor> teacherCounselorList() {
        return baseMapper.findTeacherCounselorList();
    }

    @Override
    public JSONObject homePage() {
        JSONObject homePageObject = new JSONObject();
        try {
            homePageObject.put("topImages","http://" + extranetIp + ":8081/pictures/lianhua.png");
            List<String> carouselList = new ArrayList<>();
            carouselList.add("http://" + extranetIp + ":8081/pictures/lunbotu1.png");
            carouselList.add("http://" + extranetIp + ":8081/pictures/lunbotu2.jpg");
            carouselList.add("http://" + extranetIp + ":8081/pictures/lunbotu3.jpg");
            homePageObject.put("carouse",carouselList);
            homePageObject.put("homePictureOne","http://" + extranetIp + ":8081/pictures/shouye1.jpg");
            homePageObject.put("homePictureTwo","http://" + extranetIp + ":8081/pictures/shouye2.jpg");
            homePageObject.put("homePictureThree","http://" + extranetIp + ":8081/pictures/shouye3.jpg");
            homePageObject.put("confusedList",confused());
            homePageObject.put("areaList",area());
            homePageObject.put("homePictureFour","http://" + extranetIp + ":8081/pictures/shouye4.jpg");
            homePageObject.put("homePictureFives","http://" + extranetIp + ":8081/pictures/shouye5.jpg");

            JSONArray speechArray = new JSONArray();
            JSONObject sixObject = new JSONObject();
            sixObject.put("homePictureUrl","http://" + extranetIp + ":8081/pictures/shouye6.jpg");
            Map<String,String> courseOne = new HashMap<>(2);
            courseOne.put("title","《总裁演讲突破班》");
            courseOne.put("value","克服恐惧，提升演讲自信，如何进行会议总结。年会，招商会等事业场景演讲。如何介绍公司，产品，团队，项目");
            sixObject.put("homeText",courseOne);
            sixObject.put("buttonName","了解总裁演讲突破班");
            speechArray.add(sixObject);

            JSONObject sevenObject = new JSONObject();
            sevenObject.put("homePictureUrl","http://" + extranetIp + ":8081/pictures/shouye7.jpg");
            Map<String,String> courseTwo = new HashMap<>(2);
            courseTwo.put("title","《演讲改变人生》");
            courseTwo.put("value","1.会演讲有什么用2.演讲为什么紧张忘词3.如何练就魅力桑音4.如何发表营销演讲？5.如何.....");
            sevenObject.put("homeText",courseTwo);
            sevenObject.put("buttonName","了解演讲改变人生");
            speechArray.add(sevenObject);

            JSONObject eightObject = new JSONObject();
            eightObject.put("homePictureUrl","http://" + extranetIp + ":8081/pictures/shouye8.jpg");
            Map<String,String> courseEight = new HashMap<>(2);
            courseEight.put("title","《青少年演讲口才》");
            courseEight.put("value","1.提高演讲咨询2.增强语言表达能力3.知感恩，懂卑谦4.有耐心，善坚持5.遇事学会沟通");
            eightObject.put("homeText",courseEight);
            eightObject.put("buttonName","青少年演讲口才`");
            speechArray.add(eightObject);

            homePageObject.put("speechd",speechArray);
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
            teacherCounselorObject.put("topImages","http://" + extranetIp + ":8081/pictures/lianhua.png");
            List<String> carouselList = new ArrayList<>();
            carouselList.add("http://" + extranetIp + ":8081/pictures/lunbotu1.png");
            carouselList.add("http://" + extranetIp + ":8081/pictures/lunbotu2.jpg");
            carouselList.add("http://" + extranetIp + ":8081/pictures/lunbotu3.jpg");
            teacherCounselorObject.put("carouse",carouselList);
            teacherCounselorObject.put("teacherCounselor",this.teacherCounselorList());
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return teacherCounselorObject;
    }

}
