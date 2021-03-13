package cc.mrbird.febs.system.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 课程表 Entity
 *
 * @author Prock.Liy
 * @date 2021-03-13 23:35:20
 */
@Data
@TableName("course")
public class Course {

    /**
     * code
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
     * 描述图片
     */
    @TableField("IMAGE")
    private String image;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

}
