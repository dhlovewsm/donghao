package com.bosssoft.com.cn.hr.train.monitoring.entity;

import java.util.Date;

public class NotCommitUserBean {
    private int userId;
    private String userName;
    private String userTaskTitle;
    private Date userDateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserDateTime() {
        return userDateTime;
    }

    public String getUserTaskTitle() {
        return userTaskTitle;
    }

    public void setUserDateTime(Date userDateTime) {
        this.userDateTime = userDateTime;
    }

    public void setUserTaskTitle(String userTaskTitle) {
        this.userTaskTitle = userTaskTitle;
    }
}
