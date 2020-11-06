package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;

import com.shsxt.crm.po.Menu;
import com.shsxt.crm.service.MenuService;
import com.shsxt.crm.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("list")
    public ResultInfo selectList(){
        List<Menu> list = menuService.selectList();
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("菜单");
        resultInfo.setResult(list);
        return resultInfo;
    }
    @RequestMapping("insert")
    public ResultInfo insert(MenuVo vo){
        menuService.insert(vo);
        ResultInfo resultInfo = new ResultInfo();
        return  resultInfo;
    }
    @RequestMapping("update")
    public ResultInfo update(MenuVo vo){
        menuService.update(vo);
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
    @RequestMapping("delete")
    public String delete(String id){
        menuService.delete(id);
        return "success";
    }

}
