package com.bosssoft.com.cn.hr.train.monitoring.service;

import com.bosssoft.com.cn.hr.train.monitoring.entity.Admin;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Mail;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Task;
import com.bosssoft.com.cn.hr.train.monitoring.entity.UserBean;
import com.bosssoft.com.cn.hr.train.monitoring.impl.LoadFileImpl;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 加载配置文件
 */
public class LoadFile implements LoadFileImpl {

    /**
     * 加载管理员配置文件
     * @param file 管理员配置文件
     * @return admin对象
     */

    public Admin LoadAdminFile(File file){
        XmlReadService xmlReadWriteService = new XmlReadService();
        XStream xStream = new XStream();
        xStream.processAnnotations(Admin.class);
        String xml = xmlReadWriteService.ReadXml(file);/*读取xml文件*/
        List<Admin> list = (ArrayList)xStream.fromXML(xml);/*转换为对象集合*/
        Admin admin = list.get(0);/*只有一个对象*/
        return admin;/*返回值*/
    }
    public List<UserBean> LoadUserFile(File file){
        XmlReadService xmlReadWriteService = new XmlReadService();
        XStream xStream = new XStream();
        xStream.processAnnotations(UserBean.class);
        String xml = xmlReadWriteService.ReadXml(file);
        List<UserBean> list = (ArrayList)xStream.fromXML(xml);/*将xml文件转换为UserBean对象集合*/
        return list;
    }
    public List<Mail> LoadMailFile(File file){
        XmlReadService xmlReadWriteService = new XmlReadService();
        XStream xStream = new XStream();
        xStream.processAnnotations(Mail.class);
        String xml = xmlReadWriteService.ReadXml(file);
        List<Mail> list = (ArrayList)xStream.fromXML(xml);/*转换为mail对象结集合*/
        return list;
    }
    public List<Task> LoadTaskFile(File file){
        XmlReadService xmlReadWriteService = new XmlReadService();
        XStream xStream = new XStream();
        xStream.processAnnotations(Task.class);
        String xml = xmlReadWriteService.ReadXml(file);
        List<Task> list = (ArrayList)xStream.fromXML(xml);/*转换为task对象集合*/
        return list;
    }
}
