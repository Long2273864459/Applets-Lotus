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
@TableName("teacher_counselor")
@Excel("师资表")
public class TeacherCounselor implements Serializable, Cloneable {

    private static final long serialVersionUID = -8161497082860288630L;
    /**
     * ID
     */
    @TableId(value = "CODE", type = IdType.AUTO)
    private Long code;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    private String description;

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
    public TeacherCounselor clone() throws CloneNotSupportedException {
        return (TeacherCounselor) super.clone();
    }
}
