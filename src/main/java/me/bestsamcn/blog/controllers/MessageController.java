package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.enums.MessageType;
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

    @GetMapping(name="分页", value="getList")
    @ResponseBody
    public Response getList(@RequestParam(name="pageIndex", defaultValue = "1")  int pageIndex,
                            @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(name="type", required = false, defaultValue = "10") int type,
                            @RequestParam(name="keyword", required = false) String keyword){
        Response res = messageService.getList(pageIndex, pageSize, type, keyword);
        return res;
    }
}
