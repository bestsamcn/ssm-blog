package me.bestsamcn.blog.controllers;

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

    @ResponseBody
    @RequestMapping("/json")
    public Map<String, String> json(){
        Map<String, String> map = new HashMap();
        map.put("name", "123");

        return map;
    }
    @RequestMapping("/")
    public String index(){
        return "/test";
    }

}
