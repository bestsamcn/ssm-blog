package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Hot;
import me.bestsamcn.blog.services.HotService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/8 20:56
 */
@Controller("hotController")
@RequestMapping(name="热词模块", value="/hot")
public class HotController {

    @Autowired
    HotService hotService;

    @PostMapping(name="添加", value="add")
    @ResponseBody
    @LoginRequired
    @Transactional(rollbackFor = Exception.class)
    public Response add(@RequestParam("name") String name) throws Exception{
        Response res = hotService.add(name);
        return res;
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    @LoginRequired
    public Response delete(@RequestParam("id") String id) throws Exception{
        Response res = hotService.delete(id);
        return res;
    }

    @GetMapping(name="查询", value="getById")
    @ResponseBody
    public Response getById(@RequestParam("id") String id) throws Exception{
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        Hot hot = hotService.selectById(id);
        if(hot != null){
            return Response.build(hot);
        }
        return Response.error();
    }

    @GetMapping(name="查询", value="getList")
    @ResponseBody
    public Response getList() throws Exception{
        List<Hot> list = hotService.getList();
        return Response.build(list);
    }

    @PostMapping(name="编辑", value="edit")
    @ResponseBody
    @LoginRequired
    public Response edit(@RequestParam("id") String id, @RequestParam("name") String name){
        Response res = hotService.edit(id, name);
        return res;
    }
}
