package com.bosssoft.com.cn.hr.train.monitoring.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;


@XStreamAlias("mail")
public class Mail implements Serializable {
    @XStreamAlias("mailTitle")
   private String mailTitle;
    @XStreamAlias("mailText")
   private String mailText;

    public Mail(){}

    public String getMailText() {
        return mailText;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }
}
