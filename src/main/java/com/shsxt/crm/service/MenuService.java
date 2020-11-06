package com.shsxt.crm.service;

import com.shsxt.crm.po.Menu;
import com.shsxt.crm.vo.MenuVo;

import java.util.List;


public interface MenuService {

    void insert(MenuVo vo);

    List<Menu> selectList();

    void update(MenuVo vo);

    void delete(String id);
}
