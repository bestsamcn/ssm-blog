package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.ControllerLog;
import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.services.AdminService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    @LoginRequired
    public Response getAdminById(@RequestParam("id") String id){
        Response res = adminService.getById(id);
        return res;
    }

    @PostMapping(name="创建管理员", value="add")
    @ResponseBody
    public Response add(@RequestParam("account") String account, @RequestParam("password") String password) throws Exception{
        Response res = adminService.add(account, password);
        return res;
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    @LoginRequired
    public Response delete(@RequestParam("id") String id){
        Response res = adminService.delete(id);
        return res;
    }

    @GetMapping(name="分页", value="getList")
    @ResponseBody
    @LoginRequired
    public Response getList(
            @RequestParam("pageIndex") int pageIndex,
            @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize){
        Response res = adminService.getList(pageIndex,pageSize);
        return res;
    }

    @PostMapping(name="编辑", value="edit")
    @ResponseBody
    @LoginRequired
    public Response edit(
            @RequestParam("id") String id,
            @RequestParam("account") String account,
            @RequestParam("email") String email,
            @RequestParam("mobile") String mobile,
            @RequestParam("avatar") String avatar){
        Response res = adminService.edit(id, account, email, mobile, avatar);
        return res;
    }

    @PostMapping(name="登陆", value="login")
    @ResponseBody
    @ControllerLog(description = "登陆")
    public Response login(
            @CookieValue(value="JSESSIONID", required = false) String JSESSIONID,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            HttpSession session,
            HttpServletResponse resp){
        Response res = adminService.login(account, password, JSESSIONID, session, resp);
        return res;
    }

    @RequestMapping(name="退出登陆", value = "logout")
    @ResponseBody
    @LoginRequired
    public Response logout(@CookieValue("JSESSIONID") String JSESSIONID, HttpSession httpSession, HttpServletRequest req, HttpServletResponse resp){
        Response res = adminService.logout(JSESSIONID, httpSession, req, resp);
        return res;
    }

    @PostMapping(name="修改密码", value="editPassword")
    @ResponseBody
    @LoginRequired
    public Response editPassword(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam("rePassword") String rePassword){
        Response res = adminService.editPassword(id, password, rePassword);
        return res;
    }

    @GetMapping(name="获取当前用户信息", value="getInfo")
    @ResponseBody
    @LoginRequired
    public Response getInfo(@CookieValue("JSESSIONID") String JSESSIONID){
        Response res = adminService.getInfo(JSESSIONID);
        return res;
    }

    @GetMapping(name="静态", value="/")
    public String index(){
        return "/test";
    }
}
