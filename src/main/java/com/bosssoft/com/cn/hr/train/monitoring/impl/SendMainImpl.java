package com.bosssoft.com.cn.hr.train.monitoring.impl;

import com.bosssoft.com.cn.hr.train.monitoring.domain.Send;

public interface SendMainImpl {
    public void sendAdminNotCommit(final Send send);
    public void sendUser(final Send send);
}
