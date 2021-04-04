package cc.mrbird.febs.system.entity;

import cc.mrbird.febs.common.converter.TimeConverter;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Prock.Liy
 */
@Data
@TableName("course_intention")
@Excel("课程表")
public class CourseIntention implements Serializable, Cloneable {

    private static final long serialVersionUID = -8222159390250355014L;
    /**
     * code
     */
    @TableId(value = "CODE", type = IdType.AUTO)
    private Long code;

    /**
     * 用户 ID
     */
    @TableField("USER_ID")
    private Long userId;


    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 困惑点
     */
    @TableField("CONFUSED")
    private String confused;

    /**
     * 地区
     */
    @TableField("AREA")
    private String area;

    /**
     * 预约天数 ，多少天前
     */
    @TableField(exist = false)
    private String Days;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    @ExcelField(value = "修改时间", writeConverter = TimeConverter.class)
    private Date modifyTime;

    @Override
    public CourseIntention clone() throws CloneNotSupportedException {
        return (CourseIntention) super.clone();
    }
}
