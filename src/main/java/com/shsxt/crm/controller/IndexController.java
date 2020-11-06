package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
