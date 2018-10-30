package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Admin;

/**
 * @Author: Sam
 * @Date: 2018/10/26 0:40
 */
public interface AdminMapper {
    public Admin findUserById(int id);
}
