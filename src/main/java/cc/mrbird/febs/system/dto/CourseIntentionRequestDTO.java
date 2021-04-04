package cc.mrbird.febs.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Prock.Liy
 */
@Data
public class CourseIntentionRequestDTO implements Serializable, Cloneable {

    private static final long serialVersionUID = -8222159390250355014L;

    private Long userId;
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 困惑点
     */
    private List<String> confused;

    /**
     * 地区
     */
    private List<String> area;

    ///**
    // * 验证码
    // */
    //private String verifyCode;
}
