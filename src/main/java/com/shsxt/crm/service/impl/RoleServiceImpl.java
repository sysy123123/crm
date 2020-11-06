package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.po.RoleName;
import com.shsxt.crm.service.RoleService;
import com.shsxt.crm.vo.RoleNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;



    @Override
    public Map<String, Object> selectList(RoleNameVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getLimit());

        List<RoleName> list = roleDao.selectList(vo);
        PageInfo<RoleName> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", list);
        return map;
    }

    @Override
    public RoleName selectRoleInfoById(String roleNameId) {
        RoleName roleName = roleDao.selectRoleInfoById(roleNameId);
        return roleName;
    }

    @Override
    public void insert(RoleName roleName) {
        roleDao.insert(roleName);
    }

    @Override
    public void updateRole(RoleName roleName) {
        roleDao.updateRole(roleName);
    }

    @Override
    public void deleteIds(String[] ids) {
        roleDao.delete(ids);
    }


}

