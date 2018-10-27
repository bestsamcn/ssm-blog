package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.User;

/**
 * @Author: Sam
 * @Date: 2018/10/26 0:40
 */
public interface UserMapper {
    public User findUserById(String id);
}
