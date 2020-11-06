package com.shsxt.crm.service;

import com.shsxt.crm.po.RoleName;
import com.shsxt.crm.vo.RoleNameVo;

import java.util.Map;

public interface RoleService {




   Map<String, Object> selectList(RoleNameVo vo);

    RoleName selectRoleInfoById(String roleNameId);

    void insert(RoleName roleName);

    void updateRole(RoleName roleName);

    void deleteIds(String[] ids);
}
