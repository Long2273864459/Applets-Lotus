package cc.mrbird.febs.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Prock.Liy
 */
@Data
public class CourseIntentionResponseDTO implements Serializable, Cloneable {

    private static final long serialVersionUID = -8222159390250355014L;

    private Long code;
    /**
     * 用户名
     */
    private String courseIntentionInfo;

    /**
     * 手机号
     */
    private Date createTime;

}
