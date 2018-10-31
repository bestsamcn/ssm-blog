package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:53
 */


@RequestMapping(name="用户模块", value="/admin")
@Controller("adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(name="根据用户id获取用户", value="getById")
    @ResponseBody
    public Response<Admin> getAdminById(@RequestParam("id") String id){
        return Response.build(adminService.getById(id));
    }

    @RequestMapping(name="创建管理员", value="add", method = RequestMethod.POST)
    @ResponseBody
    public Response add(@RequestParam("account") String account, @RequestParam("password") String password) throws Exception{
        Response res = adminService.add(account, password);
        return res;
    }
    @RequestMapping(name="静态", value="/")
    public String index(){
        return "/test";
    }
}
