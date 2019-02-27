package com.bosssoft.com.cn.hr.train.monitoring.domain;

public class ProjectMain {
    public static void main(String[] args) {
        new TaskThread().start();
        new AdminThread().start();

    }
    public static class TaskThread extends Thread{
        Send send = new Send();
        SendMain sendMain = new SendMain();
        @Override
        public void run() {
                sendMain.sendUser(send);
            }
    }
    public static class AdminThread extends Thread{
        Send send = new Send();
        SendMain sendMain = new SendMain();

        @Override
        public void run() {
            sendMain.sendAdminNotCommit(send);
        }
    }
}
