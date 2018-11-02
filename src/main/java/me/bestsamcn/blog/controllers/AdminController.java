package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:53
 */


@RequestMapping(name="用户模块", value="/admin")
@Controller("adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(name="根据用户id获取用户", value="getById")
    @ResponseBody
    public Admin getAdminById(@RequestParam("id") String id){
        Admin admin = adminService.getById(id);
        return admin;
    }

    @PostMapping(name="创建管理员", value="add")
    @ResponseBody
    public Response add(@RequestParam("account") String account, @RequestParam("password") String password) throws Exception{
        Response res = adminService.add(account, password);
        return res;
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    public Response delete(@RequestParam("id") String id){
        Response res = adminService.delete(id);
        return res;
    }

    @GetMapping(name="分页", value="getList")
    @ResponseBody
    public Response getList(@RequestParam("pageIndex") int pageIndex,
                            @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize){
        Response res = adminService.getList(pageIndex,pageSize);
        return res;
    }

    @PostMapping(name="编辑", value="edit")
    @ResponseBody
    public Response edit(@RequestParam("id") String id, @RequestParam("account") String account, @RequestParam("email") String email, @RequestParam("mobile") String mobile, @RequestParam("avatar") String avatar){
        Response res = adminService.edit(id, account, email, mobile, avatar);
        return res;
    }

    @GetMapping(name="静态", value="/")
    public String index(){
        return "/test";
    }
}
