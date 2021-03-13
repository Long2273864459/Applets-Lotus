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
@TableName("course")
@Excel("精品课程表")
public class ExcellentCourse implements Serializable, Cloneable {


    private static final long serialVersionUID = 3632117117007904328L;
    /**
     * 用户 ID
     */
    @TableId(value = "CODE", type = IdType.AUTO)
    private Long code;

    /**
     * 描述图片
     */
    @TableField("IMAGE")
    private Long image;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 分类
     */
    @TableField("SORT")
    private String sort;

    /**
     * 价格
     */
    @TableField("PRICE")
    private Double price;

    /**
     * 产品说明
     */
    @TableField("PRODUCT_MANUAL")
    private String productManual;


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
    public ExcellentCourse clone() throws CloneNotSupportedException {
        return (ExcellentCourse) super.clone();
    }
}
