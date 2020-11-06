package com.shsxt.crm.dao;

import com.shsxt.crm.po.RoleName;
import com.shsxt.crm.vo.RoleNameVo;

import java.util.List;

public interface RoleDao {
 

  List<RoleName> selectList(RoleNameVo vo);

  RoleName selectRoleInfoById(String roleNameId);


  void insert(RoleName roleName);

  void updateRole(RoleName roleName);

  void delete(String[] ids);
}
