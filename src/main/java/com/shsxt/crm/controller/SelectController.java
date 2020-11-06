package com.shsxt.crm.controller;

import com.shsxt.crm.po.SelectRole;
import com.shsxt.crm.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("select")
public class SelectController {
    @Autowired
    private SelectService selectService;
    @RequestMapping("check")
    public String selectRole(SelectRole selectRole){
        selectService.selectRole(selectRole);
        return "success";
    }
}
