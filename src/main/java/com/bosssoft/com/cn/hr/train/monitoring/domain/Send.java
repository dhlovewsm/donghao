package com.bosssoft.com.cn.hr.train.monitoring.domain;

import com.bosssoft.com.cn.hr.train.monitoring.entity.*;
import com.bosssoft.com.cn.hr.train.monitoring.service.FileScanner;
import com.bosssoft.com.cn.hr.train.monitoring.service.LoadFile;
import com.bosssoft.com.cn.hr.train.monitoring.service.SendEmailService;
import org.slf4j.Logger;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Send {
    SendEmailService sendEmailService = new SendEmailService();
    FileProperties fileProperties = new FileProperties();
    LoadFile loadFile = new LoadFile();
    File userFile = new File(fileProperties.userXmlString); /*指定user配置文件目录*/
    File adminFile = new File(fileProperties.adminXmlString);
    File mailFile = new File(fileProperties.mailXmlString);
    File taskFile = new File(fileProperties.taskXmlString);
    File folderFile = new File(fileProperties.fileXmlString);

    /**
     * 发送任务邮件
     * 将当天任务发送给用户
     */
    public void sendTask(){

        /**
         * 载入admin配置文件
         * 载入user配置文件
         * 载入邮箱模板配置文件
         * 载入任务列表配置文件
         */
        Admin admin = loadFile.LoadAdminFile(adminFile);
        List<UserBean> userList = loadFile.LoadUserFile(userFile);
        List<Mail> mailList = loadFile.LoadMailFile(mailFile);
        List<Task> taskList = loadFile.LoadTaskFile(taskFile);
        Date date = new Date();
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        String str = date1.format(date);/*获取系统年月日*/
        System.out.println(str);
        List<Task> ttll = new ArrayList<>();
        for (Task tt : taskList){
            if (tt.getTaskDate().equals(str))
                ttll.add(tt);
        }
        Task task = ttll.get(0);
        Mail mail = mailList.get(3);
        mail.setMailText(task.getTaskDate()+task.getTaskTitle());/*为mail对象设置邮件内容*/
        List<String> contacts = new ArrayList<>();
        for (UserBean userBean : userList){         /*循环获取user对象中的邮箱*/
            contacts.add(userBean.getUserEmail());
            }
            try {
                sendEmailService.SendEmail(admin,contacts,mail); /*发送邮箱*/
        } catch (MessagingException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    /**
     *
     * @throws IOException
     * @throws MessagingException
     *  为管理员发送通知
     *  将作业提交结果发送给管理员
     */
    public void sendNotice() throws IOException, MessagingException {
        Admin admin = loadFile.LoadAdminFile(adminFile);/*加载管理员配置文件*/
        FileScanner fileScanner = new FileScanner();/*创建文件扫描器对象*/
        List<Mail> mailList = loadFile.LoadMailFile(mailFile);/*加载邮件模板配置文件*/
        List<Task> taskList = loadFile.LoadTaskFile(taskFile);/*加载任务列表配置文件*/
        Task task = taskList.get(0);
        Mail mail = mailList.get(4);
        List<String> notCommitUser = fileScanner.scan(folderFile);/*将未提交作业的用户以list返回*/
        String value ="";
        for (int i=0;i<notCommitUser.size();i++){
            value = value + notCommitUser.get(i)+("\n");/*读取未提交的用户姓名*/
        }
        mail.setMailText(task.getTaskDate()+"未提交作业"+task.getTaskTitle()+"的学生名单如下：\n"+value);/*装载到mail内容中*/
        List<String> adminList = new ArrayList<>();
        adminList.add(admin.getAdminEmail());/*向管理员发送*/
        sendEmailService.SendEmail(admin,adminList,mail);/*发送邮件*/
    }

    /**
     * 分别给未提交作业的用户发送邮件
     * 线程中和管理员一起发送
     * @throws IOException
     * @throws MessagingException
     */
    public void sendNotCommit() throws IOException, MessagingException {
        Admin admin = loadFile.LoadAdminFile(adminFile);/*加载配置文件*/
        FileScanner fileScanner = new FileScanner();
        List<Mail> mailList = loadFile.LoadMailFile(mailFile);
        List<UserBean> userList = loadFile.LoadUserFile(userFile);
        Mail mail = mailList.get(0);
        List<String> notCommitUser = fileScanner.scan(folderFile);
        List<String> list = new ArrayList<>();
        for (String str : notCommitUser){
            for (UserBean userBean : userList){
                if (str.equals(userBean.getUserName()))
                    list.add(userBean.getUserEmail());/*通过取得的用户姓名获取用户邮箱*/
            }
        }
        sendEmailService.SendEmail(admin,list,mail);/*发送邮件*/
    }
}
