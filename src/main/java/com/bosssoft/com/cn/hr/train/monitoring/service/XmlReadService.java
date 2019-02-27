package com.bosssoft.com.cn.hr.train.monitoring.service;

import com.bosssoft.com.cn.hr.train.monitoring.impl.XmlReadImpl;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * 实现xml文件到string字符的转换
 */
public class XmlReadService implements XmlReadImpl {
    public String ReadXml(File file){
        String xmlString = null;
        try {
            SAXReader saxReader=new SAXReader();
            Document document = saxReader.read(file);
            xmlString = document.asXML();/*将xml文件转换为string字符*/
        }catch (Exception e){
            e.printStackTrace();
        }
        return xmlString;
    }
}
