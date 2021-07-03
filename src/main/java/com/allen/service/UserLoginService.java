package com.allen.service;

import com.allen.pojo.User;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/15 14:42
 */
public interface UserLoginService {

    //查询
    List<User> queryAll();

    //添加数据
    int add(User user);

    //根据用户名查询数据
    User queryByName(String username);
}
