package cc.mrbird.febs.system.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * @Author Prock.Liy
 * @Date 2021/3/23 11:19
 * @Descripttion
 * @Version 1.0
 */
@Data
public class UserShippingAddressDTO {

    public Long userId;

    /**
     * 收货姓名
     */
    public String receivingName;
    /**
     * 电话
     */
    public String mobile;
    /**
     * 地区
     */
    public List<JSONObject> area;
    /**
     * 详细地址
     */
    public String address;
}
