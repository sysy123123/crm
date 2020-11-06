package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.vo.SaleChanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController {
    @Autowired
    private SaleChanceService saleChanceService;
    @RequestMapping("index")
    public String index(){
        return ("saleChance/sale_chance");
    }
    @RequestMapping("toAddOrUpdatePage")
    public String toAddOrUpdatePage(HttpServletRequest request, String saleChanceId){
        //不为空则是编辑，为空则为添加
        if(saleChanceId!=null){
            SaleChance saleChance = saleChanceService.selectSaleChanceInfoById(saleChanceId);
            // 设置请求域
            request.setAttribute("saleChance",saleChance);
        }
        return ("saleChance/add_update");
    }


    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> select(SaleChanceVo vo){

        Map<String, Object> map = saleChanceService.selectList(vo);

        return map;
    }


    @RequestMapping("add")
    @ResponseBody
    public String insert(SaleChance saleChance){
        saleChanceService.insert(saleChance);
        return "success";
    }
    @RequestMapping("update")
    @ResponseBody
    public String update(SaleChance saleChance){
        saleChanceService.update(saleChance);
        return "success";
    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(String[] ids){
        saleChanceService.deleteIds(ids);
        return "success";
    }
}
