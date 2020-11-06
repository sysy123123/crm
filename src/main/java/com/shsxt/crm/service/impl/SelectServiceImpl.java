package com.shsxt.crm.service.impl;

import com.shsxt.crm.dao.SelectDao;
import com.shsxt.crm.po.SelectRole;
import com.shsxt.crm.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectDao selectDao;
    @Override
    public void selectRole(SelectRole selectRole) {
        selectDao.selectRole(selectRole);
    }
}
