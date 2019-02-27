package com.bosssoft.com.cn.hr.train.monitoring.service;

import com.bosssoft.com.cn.hr.train.monitoring.entity.FileProperties;
import com.bosssoft.com.cn.hr.train.monitoring.entity.FolderInfo;
import com.bosssoft.com.cn.hr.train.monitoring.entity.UserBean;
import com.bosssoft.com.cn.hr.train.monitoring.impl.FileScannerImpl;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现对指定文件目录下的监控
 *
 */
public class FileScanner implements FileScannerImpl {
    public List<String> scan(File file)  {
        XStream xStream = new XStream();
        FileProperties fileProperties = new FileProperties();/*创建配置文件对象*/
        File file1 = new File(fileProperties.userXmlString);/*获取配置文件*/
        XmlReadService xmlReadWriteService = new XmlReadService();
        String userXml = xmlReadWriteService.ReadXml(file1);/*读取用户配置文件*/
        String folderXml = xmlReadWriteService.ReadXml(file);/*读取指定文件夹配置*/
        xStream.processAnnotations(UserBean.class);
        xStream.processAnnotations(FolderInfo.class);
        List<UserBean> userList = (ArrayList)xStream.fromXML(userXml);/*转换为UserBean对象集合*/
        List<FolderInfo> folderList = (ArrayList) xStream.fromXML(folderXml);/*转换为folder对象集合*/
        FolderInfo folderInfo = folderList.get(0);/*指定文件为folderInfo*/
        List<String> list = new ArrayList<>();
        File folderFile = new File(folderInfo.getFolderLocation());/*获取到指定的文件目录*/
        String[] folders = folderFile.list();/*将指定文件下的所有文件获取到数组*/
        for (UserBean userBean : userList) {
           if (isHave(folders,userBean.getUserName()))/*如果文件数组中有该用户的姓名*/
               continue;
           else list.add(userBean.getUserName());/*将没有的用户姓名存到list*/
        }

        return list;
    }
    public static boolean isHave(String[] strs,String s){
        /*此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
         * */
        for(int i=0;i<strs.length;i++){
            if(strs[i].indexOf(s)!=-1){//循环查找字符串数组中的每个字符串中是否包含所有查找的内容
                return true;//查找到了就返回真，不在继续查询
            }
        }
        return false;//没找到返回false
    }
}
