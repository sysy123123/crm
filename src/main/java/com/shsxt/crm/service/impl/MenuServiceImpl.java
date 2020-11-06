package com.shsxt.crm.service.impl;

import com.shsxt.crm.dao.MenuDao;
import com.shsxt.crm.po.Menu;
import com.shsxt.crm.service.MenuService;
import com.shsxt.crm.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;


    @Override
    public void insert(MenuVo vo) {

        menuDao.insert(vo);
    }

    @Override
    public List<Menu> selectList() {
        List<Menu> list = menuDao.selectList();
        return list;
    }

    @Override
    public void update(MenuVo vo) {
        menuDao.update(vo);
    }

    @Override
    public void delete(String id) {
        menuDao.delete(id);
    }


}