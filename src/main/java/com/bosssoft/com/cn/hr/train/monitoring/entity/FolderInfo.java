package com.bosssoft.com.cn.hr.train.monitoring.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("folder")
public class FolderInfo {
    @XStreamAlias("folderLocation")
    private String folderLocation;

    public String getFolderLocation() {
        return folderLocation;
    }

    public void setFolderLocation(String folderLocation) {
        this.folderLocation = folderLocation;
    }
}
