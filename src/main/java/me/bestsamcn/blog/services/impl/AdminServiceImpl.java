package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.AdminMapper;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Sam
 * @Date: 2018/10/28 18:18
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findUserById(int id) {
        return adminMapper.findUserById(id);
    }
}
