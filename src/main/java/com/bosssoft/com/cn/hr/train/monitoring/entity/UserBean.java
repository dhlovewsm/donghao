package com.bosssoft.com.cn.hr.train.monitoring.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("user")
public class UserBean implements Serializable {

    @XStreamAlias("userId")
    private String userId;
    @XStreamAlias("userName")
    private String userName;
    @XStreamAlias("userEmail")
    private String userEmail;
    public UserBean(){}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
