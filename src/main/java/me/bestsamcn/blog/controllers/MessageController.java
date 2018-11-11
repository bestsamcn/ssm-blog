package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.enums.MessageType;
import me.bestsamcn.blog.models.Message;
import me.bestsamcn.blog.services.MessageService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Sam
 * @Date: 2018/11/10 22:28
 */
@RequestMapping(name="留言模块", value="/message")
@Controller("messageController")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(name="新增", value="add")
    @ResponseBody
    public Response add(String name, String email, String content){
        Response res = messageService.add(name, email, content);
        return res;
    }

    @GetMapping(name="分页搜索", value="getList")
    @ResponseBody
    @LoginRequired
    public Response getList(@RequestParam(name="pageIndex", defaultValue = "1")  int pageIndex,
                            @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(name="type", required = false, defaultValue = "10") int type,
                            @RequestParam(name="keyword", required = false) String keyword){
        Response res = messageService.getList(pageIndex, pageSize, type, keyword);
        return res;
    }

    @GetMapping(name="获取详情", value="getById")
    @ResponseBody
    @LoginRequired
    public Response getById(@RequestParam("id") String id){
        if(id == null || id.trim().length() != 32){
            return Response.error("无此数据");
        }
        try{
            Message message = messageService.selectById(id);
            return Response.build(message);
        }catch (Exception e){
            return Response.error();
        }
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    @LoginRequired
    public Response delete(@RequestParam("id") String id) {
        if (id == null || id.trim().length() != 32) {
            return Response.error("无此数据");
        }
        try {
            int row = messageService.remove(id);
            if (row == 1) {
                return Response.success("删除成功");
            }
            return Response.error("删除失败");
        } catch (Exception e) {
            return Response.error();
        }
    }

    @GetMapping(name="获取相邻数据", value="getAdjoinById")
    @ResponseBody
    @LoginRequired
    public Response getAdjoinById(@RequestParam("id") String id){
        if(id == null || id.trim().length() != 32){
            return Response.error("无此数据");
        }
        Response res = messageService.getAdjoinById(id);
        return res;
    }
}
