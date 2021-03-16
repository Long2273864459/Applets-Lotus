package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.ExcellentCourse;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.mapper.ExcellentCourseMapper;
import cc.mrbird.febs.system.mapper.UserMapper;
import cc.mrbird.febs.system.service.ICourseIntentionService;
import cc.mrbird.febs.system.service.IExcellentCourseService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Prock.Liy
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExcellentCourseServiceImpl extends ServiceImpl<ExcellentCourseMapper, ExcellentCourse> implements IExcellentCourseService {

    @Override
    public JSONObject findExcellentCourseList(String sort,String keyWord) {
        JSONObject excellentCourseObject = new JSONObject();
        try {
            List<String> sortList = new ArrayList<>();
            sortList.add("总裁突破班");
            sortList.add("演讲改变命运");
            sortList.add("总裁演讲导师班");
            sortList.add("演说企业内训");
            sortList.add("未来领袖演讲");
            sortList.add("恰同学少年");

            excellentCourseObject.put("sortList",sortList);
            excellentCourseObject.put("courseList",baseMapper.findExcellentCourseList(sort,keyWord));
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return excellentCourseObject;
    }

    @Override
    public JSONObject findExcellentCourseDetail(Long code) {
        JSONObject excellentCourseObject = new JSONObject();
        try {
            ExcellentCourse excellentCourse = baseMapper.selectById(code);
            excellentCourseObject.put("excellentCourse",excellentCourse);
            List<ExcellentCourse> excellentCourseList = baseMapper.findExcellentCourseList(StringUtils.EMPTY,StringUtils.EMPTY);
            if (excellentCourseList.size() <=0){
                return excellentCourseObject;
            }
            List<ExcellentCourse> relatedProducts = excellentCourseList.stream()
                    .filter(excellent -> !excellent.getCode().equals(excellentCourse.getCode()))
                    .collect(Collectors.toList());
            excellentCourseObject.put("relatedProducts",relatedProducts);
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("请求资源出错，请稍后再试!");
        }
        return excellentCourseObject;
    }

    @Override
    public void addExcellentCourse(ExcellentCourse excellentCourse) {
        try {
            excellentCourse.setCreateTime(new Date());
            save(excellentCourse);
        }catch (Exception e){
            e.printStackTrace();
            throw new FebsException("新增出错，请稍后再试!");
        }
    }
}
