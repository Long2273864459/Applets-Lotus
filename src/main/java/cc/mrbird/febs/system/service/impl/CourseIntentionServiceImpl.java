package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.CourseIntention;
import cc.mrbird.febs.system.entity.CourseIntentionDTO;
import cc.mrbird.febs.system.mapper.CourseIntentionMapper;
import cc.mrbird.febs.system.service.ICourseIntentionService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cc.mrbird.febs.common.utils.LotusUtil.area;
import static cc.mrbird.febs.common.utils.LotusUtil.confused;

/**
 * @author Prock.Liy
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseIntentionServiceImpl extends ServiceImpl<CourseIntentionMapper, CourseIntention> implements ICourseIntentionService {

    @Override
    public JSONObject findCourseIntentionList() {
        JSONObject intentionObject = new JSONObject();
        try {
            intentionObject.put("topImages","http://8.136.200.209:8081/pictures/yuyuebaoming1.jpg");
            intentionObject.put("confusedList",confused());
            intentionObject.put("areaList",area());
            intentionObject.put("intentionCount",baseMapper.findCount());
            intentionObject.put("imagesOne","http://8.136.200.209:8081/pictures/yuyuebaoming2.jpg");
            intentionObject.put("imagesTwo","http://8.136.200.209:8081/pictures/yuyuebaoming3.jpg");

            // 轮播图集合
            List<String> carouselList = new ArrayList<>();
            carouselList.add("http://8.136.200.209:8081/pictures/yuyuebaoming_lunbo1.webp");
            carouselList.add("http://8.136.200.209:8081/pictures/lhys1.jpg");
            carouselList.add("http://8.136.200.209:8081/pictures/yuyuebaoming_lunbo3.webp");
            carouselList.add("http://8.136.200.209:8081/pictures/yuyuebaoming_lunbo4.webp");
            carouselList.add("http://8.136.200.209:8081/pictures/yuyuebaoming_lunbo5.webp");
            carouselList.add("http://8.136.200.209:8081/pictures/yuyuebaoming_lunbo6.webp");
            intentionObject.put("carouselList",carouselList);

            intentionObject.put("imagesThere","http://8.136.200.209:8081/pictures/yuyuebaoming5.png");

            List<CourseIntention> courseIntentionList = baseMapper.findCourseIntentionList();
            //for (CourseIntention courseIntention : courseIntentionList){
            //
            //}
            intentionObject.put("courseIntentionList",courseIntentionList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return intentionObject;
    }

    @Override
    public boolean addCourseIntention(CourseIntentionDTO courseIntentionDTO) {
        try {
            CourseIntention courseIntention = new CourseIntention();
            courseIntention.setUsername(courseIntentionDTO.getUsername());
            courseIntention.setMobile(courseIntentionDTO.getMobile());
            courseIntention.setConfused(JSONObject.toJSONString(courseIntentionDTO.getConfused()));
            courseIntention.setArea(courseIntentionDTO.getArea());
            courseIntention.setCreateTime(new Date());
            save(courseIntention);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
