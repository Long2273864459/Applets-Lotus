package cc.mrbird.febs.system.entity;

import cc.mrbird.febs.common.converter.TimeConverter;
import cc.mrbird.febs.common.utils.GenerateShortUuidUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static cc.mrbird.febs.common.utils.GenerateShortUuidUtil.generateNumber2;

/**
 * @author MrBird
 */
@Data
@TableName("t_user")
@Excel("用户信息表")
public class User implements Serializable, Cloneable {

    /**
     * 用户状态：有效
     */
    public static final String STATUS_VALID = "1";
    /**
     * 用户状态：锁定
     */
    public static final String STATUS_LOCK = "0";
    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "default.jpg";
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "1234qwer";
    /**
     * 积分
     */
    public static final long INTEGRAL_NUM = 0;

    /**
     * 会员编号
     */
    public static final String MEMBER_ID = generateNumber2();

    /**
     * 会员编号
     */
    public static final long MEMBER_GRADE = 1;

    private static final long serialVersionUID = -4352868070794165001L;
    /**
     * 用户 ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    @Size(min = 4, max = 10, message = "{range}")
    @ExcelField(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 积分
     */
    @TableField("integral")
    private Long integral;

    /**
     * 会员编号
     */
    @TableField("MEMBER_ID")
    private String memberId;

    /**
     * 会员等级
     */
    @TableField("MEMBER_GRADE")
    private Long memberGrade;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    @ExcelField(value = "邮箱")
    private String email;

    /**
     * 联系电话
     */
    @TableField("MOBILE")
    //@IsMobile(message = "{mobile}")
    //@ExcelField(value = "联系电话")
    // @Desensitization(type = DesensitizationType.PHONE)
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @TableField("STATUS")
    //@NotBlank(message = "{required}")
    @ExcelField(value = "状态", writeConverterExp = "0=锁定,1=有效")
    private String status;

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

    /**
     * 最近访问时间
     */
    @TableField("LAST_LOGIN_TIME")
    @ExcelField(value = "最近访问时间", writeConverter = TimeConverter.class)
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 头像
     */
    @TableField("RECEIVING_NAME")
    private String receivingName;
    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;
    /**
     * 地区
     */
    @TableField("AREA")
    private String area;
    /**
     * 详细地址
     */
    @TableField("ADDRESS")
    private String address;


    /**
     * 密钥
     */
    @TableField("PLAIN")
    private String PLAIN;

    @TableField(exist = false)
    private JSONArray areaArray;

    @TableField(exist = false)
    private String deptIds;

    @TableField(exist = false)
    private String createTimeFrom;
    @TableField(exist = false)
    private String createTimeTo;

    @TableField(exist = false)
    private Set<String> stringPermissions;
    @TableField(exist = false)
    private Set<String> roles;

    public String getId() {
        return StringUtils.lowerCase(username);
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
