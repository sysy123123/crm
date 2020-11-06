package com.shsxt.crm.dao;

import com.shsxt.crm.po.User;
import com.shsxt.crm.vo.UserVo;

import java.util.List;

public interface UserDao {

    User selectUserByUserName(String userName);

    User selectUserInfoById(String id);

    void updateUserPwd(String id, String userPwd);

    void insertUser(User user);

    List<User> selectList(UserVo vo);

    void updateUser(User user);

    void deleteUser(List<String> ids);

}

