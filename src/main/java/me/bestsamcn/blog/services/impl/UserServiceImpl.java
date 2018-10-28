package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.UserMapper;
import me.bestsamcn.blog.models.User;
import me.bestsamcn.blog.services.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Sam
 * @Date: 2018/10/28 18:18
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        User user = userMapper.findUserById(1);
        return user;
    }
}
