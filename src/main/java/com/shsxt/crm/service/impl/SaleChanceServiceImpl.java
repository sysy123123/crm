package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.SaleDao;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.vo.SaleChanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {
    @Autowired
    private SaleDao saleDao;

    @Override
    public void insert(SaleChance saleChance) {
        saleChance.setCreateDate(new Date());
        saleChance.setCreateMan("马化腾");
        saleDao.insert(saleChance);
    }

    @Override
    public Map<String, Object> selectList(SaleChanceVo vo) {
        //使用 pageHelper 帮我们处理了总记录数
        PageHelper.startPage(vo.getPage(), vo.getLimit());

        List<SaleChance> list = saleDao.selectList(vo);
        PageInfo<SaleChance> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", list);
        return map;
    }
    //编辑
    @Override
    public SaleChance selectSaleChanceInfoById(String saleChanceId) {
        SaleChance saleChance = saleDao.selectSaleChanceInfoById(saleChanceId);
        return saleChance;
    }

    @Override
    public void update(SaleChance saleChance) {
        Integer i = saleDao.update(saleChance);
    }

    @Override
    public void deleteIds(String[] ids) {
        saleDao.deleteIds(ids);
    }
}
