package com.bosssoft.com.cn.hr.train.monitoring.impl;

import com.bosssoft.com.cn.hr.train.monitoring.entity.Admin;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.List;

public interface SendEmailImpl {
    public void SendEmail(Admin admin, List<String> contactEmails, Mail mail) throws AddressException, MessagingException, IOException;
}
