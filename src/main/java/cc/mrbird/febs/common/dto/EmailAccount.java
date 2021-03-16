package cc.mrbird.febs.common.dto;

import lombok.Data;

/**
 * @Author Prock.Liy
 * @Date 2021/3/16 14:08
 * @Descripttion
 * @Version 1.0
 */
@Data
public class EmailAccount {

    // 邮箱用户
    private String username;

    // 邮箱密码
    private String password;

    // 邮箱服务器
    private String place;
}
