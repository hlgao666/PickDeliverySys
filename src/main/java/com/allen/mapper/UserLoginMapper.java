package com.allen.mapper;

import com.allen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/15 14:39
 */

@Mapper
@Repository
public interface UserLoginMapper {

    //查询
    List<User> queryAll();

    //添加数据
    int add(User user);

    //根据用户名查询数据
    User queryByName(String username);
}
