package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.dto.CourseIntentionResponseDTO;
import cc.mrbird.febs.system.entity.CourseIntention;
import cc.mrbird.febs.system.dto.CourseIntentionRequestDTO;
import cc.mrbird.febs.system.mapper.CourseIntentionMapper;
import cc.mrbird.febs.system.service.ICourseIntentionService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cc.mrbird.febs.common.utils.LotusUtil.area;
import static cc.mrbird.febs.common.utils.LotusUtil.confused;

/**
 * @author Prock.Liy
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseIntentionServiceImpl extends ServiceImpl<CourseIntentionMapper, CourseIntention> implements ICourseIntentionService {

    @Value("${spring.extranet.ip}")
    private String extranetIp;

    @Override
    public JSONObject findCourseIntentionList() {
        JSONObject intentionObject = new JSONObject();
        try {
            intentionObject.put("topImages", "http://" + extranetIp + ":8081/pictures/yuyuebaoming1.jpg");
            intentionObject.put("confusedList", confused());
            intentionObject.put("areaList", area());
            intentionObject.put("intentionCount", baseMapper.findCount());
            intentionObject.put("imagesOne", "http://" + extranetIp + ":8081/pictures/yuyuebaoming2.jpg");
            intentionObject.put("imagesTwo", "http://" + extranetIp + ":8081/pictures/yuyuebaoming3.jpg");

            // 轮播图集合
            List<String> carouselList = new ArrayList<>();
            carouselList.add("http://"+ extranetIp +":8081/pictures/yuyuebaoming_lunbo1.webp");
            carouselList.add("http://"+ extranetIp +":8081/pictures/lhys1.jpg");
            carouselList.add("http://"+ extranetIp +":8081/pictures/yuyuebaoming_lunbo3.webp");
            carouselList.add("http://"+ extranetIp +":8081/pictures/yuyuebaoming_lunbo4.webp");
            carouselList.add("http://"+ extranetIp +":8081/pictures/yuyuebaoming_lunbo5.webp");
            carouselList.add("http://"+ extranetIp +"9:8081/pictures/yuyuebaoming_lunbo6.webp");
            intentionObject.put("carouselList", carouselList);

            intentionObject.put("imagesThere", "http://"+ extranetIp +":8081/pictures/yuyuebaoming5.png");

            List<CourseIntention> courseIntentionList = baseMapper.findCourseIntentionList();
            intentionObject.put("courseIntentionList", courseIntentionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intentionObject;
    }

    @Override
    public boolean addCourseIntention(CourseIntentionRequestDTO courseIntentionRequestDTO) {
        try {
            //List<CourseIntention> courseIntentionList = baseMapper.findCourseIntentionList();
            //for (CourseIntention courseIntention : courseIntentionList){
            //    if (courseIntention.getUsername().equals(courseIntentionDTO.getUsername()) &&
            //            courseIntention.getMobile().equals(courseIntentionDTO.getMobile())){
            //        throw new FebsException("当前用户已预约，请勿重复提交!");
            //    }
            //}
            CourseIntention courseIntention = new CourseIntention();
            courseIntention.setUserId(courseIntentionRequestDTO.getUserId());
            courseIntention.setUsername(courseIntentionRequestDTO.getUsername());
            courseIntention.setMobile(courseIntentionRequestDTO.getMobile());
            courseIntention.setConfused(JSONObject.toJSONString(courseIntentionRequestDTO.getConfused()));
            courseIntention.setArea(JSONObject.toJSONString(courseIntentionRequestDTO.getArea()));
            courseIntention.setCreateTime(new Date());
            save(courseIntention);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<CourseIntentionResponseDTO> findListByUserId(Long userId) {
        List<CourseIntentionResponseDTO> responseDTOList = new ArrayList<>();
        try {
            List<CourseIntention> courseIntentionList = baseMapper.findListByUserId(userId);
            responseDTOList = courseIntentionList.stream().map(courseIntention -> {
                CourseIntentionResponseDTO responseDTO = new CourseIntentionResponseDTO();
                List<String> confusedList = JSONArray.parseArray(courseIntention.getConfused()).toJavaList(String.class);
                StringBuffer confusedBuffer = new StringBuffer();
                confusedList.forEach(confus -> {
                    confusedBuffer.append(confus + ",");
                });
                List<String> areaList = JSONArray.parseArray(courseIntention.getArea()).toJavaList(String.class);
                StringBuffer areaBuffer = new StringBuffer();
                areaList.forEach(area -> {
                    areaBuffer.append(area + ",");
                });
                responseDTO.setCourseIntentionInfo(
                        "您的姓名: " + courseIntention.getUsername() +
                                ", 联系电话: " + courseIntention.getMobile() +
                                ",您的演讲困惑点: " + confusedBuffer +
                                "  选择地区: " + areaBuffer
                );
                responseDTO.setCode(courseIntention.getCode());
                responseDTO.setCreateTime(courseIntention.getCreateTime());
                return responseDTO;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("获取信息失败,稍后再试!");
        }
        return responseDTOList;
    }

    @Override
    public void deleteCourseIntention(Long code) {
        try {
            baseMapper.deleteById(code);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FebsException("删除失败,稍后再试!");
        }
    }
}
