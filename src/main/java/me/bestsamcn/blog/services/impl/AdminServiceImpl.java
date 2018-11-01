package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.bestsamcn.blog.dao.AdminMapper;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:57
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {



    @Autowired
    AdminMapper adminMapper;

    @Override
    public Response add(String account, String password) {
        if(account == null || account.trim().isEmpty()){
            return Response.error("用户名不能为空");
        }

        if(account.trim().length() < 3 || account.trim().length() > 26){
            return Response.error("用户名长度不能小于3或者大于26");
        }

        Admin admin = new Admin();
        admin.setId(Tools.getUUID());
        admin.setAccount(account);
        admin.setPassword(Tools.generatePassword(password));
        admin.setCreateTime(new Timestamp(new Date().getTime()));
        admin.setLastUpdateTime(new Timestamp(new Date().getTime()));
        try{
            int row = adminMapper.insert(admin);
            if(row == 1){
                return Response.success("创建成功");
            }else{
                return Response.error("创建失败");
            }
        }catch(Exception e){
            return Response.error();
        }
    }

    @Override
    public Response delete(String id){
        if(id == null || id.trim().isEmpty() || id.trim().length() != 32){
            return Response.error("无此记录");
        }
        try {
            int row = adminMapper.deleteByPrimaryKey(id);
            if(row == 1){
                return Response.success();
            }
            return Response.error("无此记录");
        }catch (Exception e){
            return Response.error();
        }
    }

    @Override
    public Response getList(int pageIndex, int pageSize){
        if(pageIndex < 0 || pageSize < 0){
            return Response.error("分页参数不正确");
        }
        try{
            PageHelper.startPage(pageIndex, pageSize);
            List<Admin> adminList = adminMapper.selectAll("last_update_time");
            PageInfo<Admin> pageInfo = new PageInfo(adminList, pageSize);
            Map<String, Object>  map= new HashMap();
            map.put("list", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
            map.put("pageIndex", pageInfo.getPageNum());
            map.put("pageSize", pageInfo.getPageSize());
            return Response.build(map);
        }catch(Exception e){
            return Response.error();
        }
    }

    @Override
    public Admin getById(String id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
