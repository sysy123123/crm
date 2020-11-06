package com.shsxt.crm.dao;

public interface DemoDao {
    void deleteRole(String userId);


    void insertRole(String userId, String[] roleIds);

    void deleteRoleMenu(String roleId);

    void insertRoleMenu(String roleId, String[] menuIds);
}
