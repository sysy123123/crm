package com.shsxt.crm.service;

import com.shsxt.crm.exception.MyException;
import com.shsxt.crm.exception.ParamsException;
import com.shsxt.crm.po.User;
import com.shsxt.crm.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    User selectUserByUserNameAndPwd(String userName, String userPwd) throws ParamsException, MyException;
    void updatePwd(String id, String oldPwd, String newPwd, String repeatPwd) throws ParamsException, MyException;

    User selectUserInfoById(String id);

    void insertUser(User user);

    Map<String, Object> selectList(UserVo vo);

    void deleteUser(List<String> ids);

    void updateUser(User user);
}
