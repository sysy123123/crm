package com.shsxt.crm.controller;


import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("updateUserRole")
    public ResultInfo updateUserRole(String userId,String[] roleIds){
        demoService.update(userId,roleIds);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        return resultInfo;
    }
    @RequestMapping("updateRoleMenu")
    public ResultInfo updateRoleMenu(String roleId,String[] menuIds){
        demoService.updateRoleMenu(roleId,menuIds);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        return resultInfo;
    }
}
