package com.shsxt.crm.service.impl;

import com.shsxt.crm.dao.DemoDao;
import com.shsxt.crm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;


    @Override
    public void update(String userId, String[] roleIds) {
        demoDao.deleteRole(userId);
        demoDao.insertRole(userId,roleIds);
    }

    @Override
    public void updateRoleMenu(String roleId, String[] menuIds) {
        demoDao.deleteRoleMenu(roleId);
        demoDao.insertRoleMenu(roleId,menuIds);
    }
}
