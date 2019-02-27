package com.bosssoft.com.cn.hr.train.monitoring.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("task")
public class Task implements Serializable {
    @XStreamAlias("taskId")
    private String taskId;
    @XStreamAlias("taskTitle")
    private String taskTitle;
    @XStreamAlias("taskTime")
    private String taskTime;

    public Task (){}

    public String getTaskDate() {
        return taskTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskDate(String taskDate) {
        this.taskTime = taskDate;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
