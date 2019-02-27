package com.bosssoft.com.cn.hr.train.monitoring.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("admin")
public class Admin {
    @XStreamAlias("adminName")
    private String adminName; /*管理员姓名*/

    @XStreamAlias("adminId")
    private String adminId;    /*管理员工号*/

    @XStreamAlias("adminEmail")
    private String adminEmail;  /*管理员邮箱地址*/

    @XStreamAlias("password")
    private String password;    /*授权码*/

    public Admin(){}
    public String getAdminName() {
        return adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
