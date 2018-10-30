package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/10/26 0:35
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @ResponseBody
    @RequestMapping("/json")
    public Admin json(){
        Map<String, String> map = new HashMap();
        map.put("name", "123");
        Admin admin = adminService.findUserById(1);
        return admin;
    }
    @RequestMapping("/")
    public String index(){
        return "/test";
    }

}
