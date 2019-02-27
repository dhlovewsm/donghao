package com.bosssoft.com.cn.hr.train.monitoring.domain;

import com.bosssoft.com.cn.hr.train.monitoring.impl.SendMainImpl;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SendMain implements SendMainImpl {

    public void sendAdminNotCommit(final Send send) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    send.sendNotice(); /*给管理员发送未提交通知*/
                    send.sendNotCommit();/*给用户发送提交提醒*/
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();/*创建定时器*/
        service.scheduleAtFixedRate
                (runnable, 60*12, 60*24, TimeUnit.MINUTES);/*启动延时运行，时隔为一天*/
    }

    public void sendUser(final Send send){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                send.sendTask();/*为用户发送任务（作业题目）*/
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();/*创建定时器*/
        service.scheduleAtFixedRate
                (runnable,0,60*24,TimeUnit.MINUTES);/*启动即运行，时隔为一天*/
    }
}