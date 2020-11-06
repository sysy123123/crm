package com.shsxt.crm.service;

import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.vo.SaleChanceVo;
import java.util.Map;

public interface SaleChanceService {
   void insert(SaleChance saleChance);


    Map<String,Object> selectList(SaleChanceVo vo);

    SaleChance selectSaleChanceInfoById(String saleChanceId);

    void update(SaleChance saleChance);

    void deleteIds(String[] ids);
}
