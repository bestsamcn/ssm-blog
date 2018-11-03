package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.model.core.ID;
import me.bestsamcn.blog.dao.AdminMapper;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.models.AdminVo;
import me.bestsamcn.blog.services.AdminService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.apache.ibatis.annotations.Param;
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

        if(password == null || password.trim().isEmpty()){
            return Response.error("密码不能为空");
        }

        if(password.trim().length() < 6 || password.trim().length() > 26){
            return Response.error("密码长度不能小于3或者大于26");
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
            PageInfo<AdminVo> pageInfo = new PageInfo(adminList, pageSize);
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
    public Response edit(String id, String account, String email, String mobile, String avatar){
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此记录");
        }
        if(account == null || account.trim().isEmpty()){
            return Response.error("用户不能为空");
        }
        if(email != null && !Tools.isMatch("[_\\w]+@\\w+\\.\\w+", email)){
            return Response.error("邮箱格式错误");
        }
        if(mobile != null  && !Tools.isMatch("1[3-8]\\d{9}", mobile)){
            return Response.error("手机号码格式错误");
        }

        try{
            Admin admin = adminMapper.selectByPrimaryKey(id);
            if(admin == null){
                return Response.error("无此记录");
            }

            admin.setAccount(account);
            admin.setEmail(email);
            admin.setMobile(mobile);
            admin.setAvatar(avatar);

            int row = adminMapper.updateByPrimaryKey(admin);
            if(row == 1){
                return Response.success("编辑成功");
            }
            return Response.error("编辑失败");

        }catch(Exception e){
            return Response.error();
        }
    }

    @Override
    public Admin getById(String id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Response login(String account, String password){
        if(account == null || account.trim().isEmpty()){
            return Response.error("用户名不能为空");
        }

        if(account.trim().length() < 3 || account.trim().length() > 26){
            return Response.error("用户名长度不能小于3或者大于26");
        }

        if(password == null || password.trim().isEmpty()){
            return Response.error("密码不能为空");
        }

        if(password.trim().length() < 6 || password.trim().length() > 26){
            return Response.error("密码长度不能小于3或者大于26");
        }

        try {
            Admin admin = adminMapper.selectOneByAccount(account);
            if(admin == null){
                return Response.error("用户名不存在");
            }
            if(!admin.getPassword().equals(Tools.generatePassword(password))){
                return Response.error("密码错误");
            }
            return Response.success("登陆成功");
        }catch(Exception e){
            return Response.error();
        }
    }

    @Override
    public Response editPassword(String id, String password, String rePassword){
        if(id == null || id.trim().isEmpty() || id.trim().length() != 32){
            return Response.error("无此数据");
        }
        if(password == null || password.trim().isEmpty()){
            return Response.error("密码不能为空");
        }
        if(password.trim().length() < 6 || password.trim().length() > 26){
            return Response.error("密码长度不能小于6或者大于26");
        }
        if(rePassword == null || rePassword.trim().isEmpty()){
            return Response.error("确认密码不能为空");
        }

        if(!password.trim().equals(rePassword.trim())){
            return Response.error("密码不一致");
        }

        try {
            Admin admin  = adminMapper.selectByPrimaryKey(id);
            if(admin == null){
                return Response.error("无此数据");
            }
            String _password = Tools.generatePassword(password);
            admin.setPassword(_password);
            int row = adminMapper.updateByPrimaryKey(admin);
            if(row == 0){
                return Response.error();
            }
            return Response.success("密码修改成功");
        }catch (Exception e){
            return Response.error();
        }
    }
}
