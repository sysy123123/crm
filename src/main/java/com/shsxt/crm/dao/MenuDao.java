package com.shsxt.crm.dao;

import com.shsxt.crm.po.Menu;
import com.shsxt.crm.vo.MenuVo;

import java.util.List;

public interface MenuDao {
    void insert(MenuVo vo);

    List<Menu> selectList();

    void update(MenuVo vo);

    void delete(String id);
}
