package com.bosssoft.com.cn.hr.train.monitoring.impl;

import com.bosssoft.com.cn.hr.train.monitoring.entity.Admin;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Task;
import com.bosssoft.com.cn.hr.train.monitoring.entity.UserBean;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Mail;

import java.io.File;
import java.util.List;

public interface LoadFileImpl {
    public Admin LoadAdminFile(File file);
    public List<UserBean> LoadUserFile(File file);
    public List<Mail> LoadMailFile(File file);
    public List<Task> LoadTaskFile(File file);
}
