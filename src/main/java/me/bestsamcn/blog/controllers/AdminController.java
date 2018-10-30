package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:53
 */

@Controller("adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(name="根据用户id获取用户", value="/getAdminById")
    @ResponseBody
    public Admin getAdminById(@RequestParam("id") String id){
        return adminService.getAdminById(id);
    }

    @RequestMapping(name="静态", value="/")
    public String index(){
        return "/test";
    }
}
