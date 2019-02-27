package com.bosssoft.com.cn.hr.train.monitoring.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileScannerImpl {
    public List<String> scan(File file);
}
