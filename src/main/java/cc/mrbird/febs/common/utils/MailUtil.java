package cc.mrbird.febs.common.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @Author Prock.Liy
 * @Date 2021/3/10 11:19
 * @Descripttion
 * @Version 1.0
 */
public class MailUtil {

    public static Boolean sendMailbox(String emailAddress,String content) {
        try {
            HtmlEmail email=new HtmlEmail();
            //设置邮箱的SMTP服务器
            email.setHostName("smtp.163.com");
            email.setSslSmtpPort("465");
            //设置发送的字符类型
            email.setCharset("utf-8");
            //收件人邮箱
            email.addTo(emailAddress);
            //发件人邮箱
            email.setFrom("long2273864459@163.com","Prock.Liy");
            email.setAuthentication("long2273864459@163.com","EDAVQBSVLZMRLUPG");
            //设置发送主题X
            email.setSubject("小程序系统邮件");
            //设置发生内容
            email.setMsg(content);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
