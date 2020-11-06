package com.shsxt.crm.dao;


import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.vo.SaleChanceVo;

import java.util.List;

public interface SaleDao {

    List<SaleChance> selectList(SaleChanceVo vo);

    void insert(SaleChance saleChance);

    Integer update(SaleChance saleChance);

    SaleChance selectSaleChanceInfoById(String saleChanceId);

    void deleteIds(String[] array);
}
