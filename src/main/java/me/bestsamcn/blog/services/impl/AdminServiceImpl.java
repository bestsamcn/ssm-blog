package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.AdminMapper;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:57
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getAdminById(String id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
