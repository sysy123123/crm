package com.shsxt.crm.service;

public interface DemoService {
    void update(String userId, String[] roleIds);

    void updateRoleMenu(String roleId, String[] menuIds);
}
