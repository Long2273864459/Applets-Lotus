package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.TeacherCounselor;
import cc.mrbird.febs.system.entity.User;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Prock.Liy
 */
public interface ITeacherCounselorService extends IService<TeacherCounselor> {

    /**
     * 首页API
     * @return jsonObject
     */
    JSONObject homePage();


    /**
     * 师资集合
     * @return JSONObject
     */
    List<TeacherCounselor> teacherCounselorList();

    /**
     * 师资集合
     * @return JSONObject
     */
    JSONObject teacherCounselor();
}
