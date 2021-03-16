package cc.mrbird.febs.common.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author Prock.Liy
 * @Date 2021/3/16 14:09
 * @Descripttion
 * @Version 1.0
 */
@Data
public class MessageInfo {

    // @NameCN("发件人地址")
    private String  from;

    // @NameCN("收件人地址")
    private List<String> to;

    // @NameCN("发送时间")
    private Date sendDate;

    // @NameCN("邮件主题")
    private String subject;

    //@NameCN("消息正文")
    private String msg;
}
