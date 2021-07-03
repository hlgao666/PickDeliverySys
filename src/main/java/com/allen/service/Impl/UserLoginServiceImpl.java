package com.allen.service.Impl;

import com.allen.mapper.UserLoginMapper;
import com.allen.pojo.User;
import com.allen.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/15 14:43
 */

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginMapper mapper;

    @Override
    public List<User> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public int add(User user) {
        return mapper.add(user);
    }

    @Override
    public User queryByName(String username) {
        return mapper.queryByName(username);
    }
}
