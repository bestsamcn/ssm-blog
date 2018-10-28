package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.User;
import me.bestsamcn.blog.services.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/json")
    public User json(){
        Map<String, String> map = new HashMap();
        map.put("name", "123");
        User user = userService.findUserById(1);
        return user;
    }
    @RequestMapping("/")
    public String index(){
        return "/test";
    }

}
