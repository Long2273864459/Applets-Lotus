package cc.mrbird.febs.common.utils;

import cc.mrbird.febs.common.dto.EmailAccount;
import cc.mrbird.febs.common.dto.MessageInfo;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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

    /**
     * ssl 465端口邮件发送
     * @param msg1
     * @param emailAccount
     * @return
     * @throws MessagingException
     */
    public static boolean sslSend(MessageInfo msg1, EmailAccount emailAccount)
            throws MessagingException {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", emailAccount.getPlace());
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        final String username = emailAccount.getUsername();
        final String password = emailAccount.getPassword();
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }});
        Message msg = new MimeMessage(session);

        // 设置发件人和收件人
        msg.setFrom(new InternetAddress(emailAccount.getUsername()));
        List<String> tos = msg1.getTo();
        Address to[] = new InternetAddress[tos.size()];
        for(int i=0;i<tos.size();i++){
            to[i] = new InternetAddress(tos.get(i));
        }
        // 多个收件人地址
        msg.setRecipients(Message.RecipientType.TO, to);
        // 标题
        msg.setSubject(msg1.getSubject());
        // 内容
        msg.setText(msg1.getMsg());
        msg.setSentDate(new Date());
        Transport.send(msg);
        System.out.println("EmailUtil ssl协议邮件发送成功!");
        return true;
    }

}
