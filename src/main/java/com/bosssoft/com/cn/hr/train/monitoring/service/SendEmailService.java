package com.bosssoft.com.cn.hr.train.monitoring.service;


import com.bosssoft.com.cn.hr.train.monitoring.entity.Admin;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Mail;
import com.bosssoft.com.cn.hr.train.monitoring.impl.SendEmailImpl;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * 邮件的发送与接收类
 *
 */
public class SendEmailService implements SendEmailImpl {

    public  void SendEmail(Admin admin,List<String> contactEmails,Mail mail) throws AddressException, MessagingException, IOException {

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp"); // 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com"); // 主机名
        properties.put("mail.smtp.port", 465);  // 端口号

        properties.put("mail.smtp.ssl.enable", "true");  // 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true"); // 设置是否显示debug信息 true 会在控制台显示相关信息
                 // 得到回话对象
        Session session = Session.getInstance(properties);
                 // 获取邮件对象
        Message message = new MimeMessage(session);
                 // 设置发件人邮箱地址
        message.setFrom(new InternetAddress(admin.getAdminEmail()));

                 // 设置邮件标题
        message.setSubject(mail.getMailTitle());
                 // 设置邮件内容
        message.setText(mail.getMailText());
                // 得到邮差对象
        Transport transport = session.getTransport();
                 // 连接自己的邮箱账户
        transport.connect(admin.getAdminEmail(), admin.getPassword());// 密码为刚才得到的授权码

        InternetAddress[] sendTo = new InternetAddress[contactEmails.size()];
        for (int i = 0; i < contactEmails.size(); i++) {
            sendTo[i] = new InternetAddress(contactEmails.get(i));
        }

                // 设置收件人地址
        message.setRecipients( RecipientType.TO, sendTo);
                 // 发送邮件 
        transport.sendMessage(message, message.getAllRecipients());
    }


}

