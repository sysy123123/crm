package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.po.RoleName;
import com.shsxt.crm.service.RoleService;
import com.shsxt.crm.vo.RoleNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("index")
    public String index(){
        return ("role/role");
    }
    @RequestMapping("addOrUpdateRolePage")
    public String addOrUpdateRolePage(HttpServletRequest request, String roleNameId){
        if(roleNameId!=null){
            RoleName roleName = roleService.selectRoleInfoById(roleNameId);
            // 设置请求域
            request.setAttribute("roleName",roleName);
        }
        return ("role/add_update");
    }
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> select(RoleNameVo vo){

        Map<String, Object> map = roleService.selectList(vo);

        return map;
    }
    @RequestMapping("add")
    @ResponseBody
    public String insert(RoleName roleName){
        roleService.insert(roleName);
        return "success";
    }
    @RequestMapping("toAddGrantPage")
    public String toAddGrantPage(){
        return ("role/grant");
    }
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateRole(RoleName roleName){
        roleService.updateRole(roleName);
        return success();
    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(String[] ids){
        roleService.deleteIds(ids);
        return  "success";
    }
}
