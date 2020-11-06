package com.shsxt.crm.vo;

import com.shsxt.crm.base.BaseQuery;

public class RoleNameVo  extends BaseQuery {
    private String roleName;
    private String roleRemark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }
}
