package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.Notify;
import me.bestsamcn.blog.services.NotifyService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Sam
 * @Date: 2018/11/11 21:36
 */
@Controller("notifyController")
@RequestMapping(name="通知模块", value="/notify")
public class NotifyController {

    @Autowired
    NotifyService notifyService;

    @PostMapping(name="新增", value="add")
    @ResponseBody
    public Response add(@RequestParam("content") String content,
                        @RequestParam("expireTime") int expireTime,
                        @RequestParam("isActive") int isActive) {
        Response res = notifyService.add(content, expireTime, isActive);
        return res;
    }

    @PostMapping(name="编辑", value="edit")
    @ResponseBody
    public Response edit(@RequestParam("content") String id,
                         @RequestParam("content") String content,
                         @RequestParam("content") int expireTime,
                         @RequestParam("content") int isActive) {
        Response res = notifyService.edit(id, content, expireTime, isActive);
        return res;
    }

    @GetMapping(name="详情", value="getById")
    @ResponseBody
    public Response getById(@RequestParam("id") String id){
        String idMsg = Tools.assertString(id, 32, 32, "id");
        if(idMsg != null){
            return Response.error("无此数据");
        }
        try{
            Notify notify = notifyService.selectById(id);
            if(notify != null){
                return Response.build(notify);
            }
            return Response.error("无此数据");
        }catch (Exception e){
            return Response.error();
        }
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    public Response delete(@RequestParam("id") String id){
        String idMsg = Tools.assertString(id, 32, 32, "id");
        if(idMsg != null){
            return Response.error("无此数据");
        }
        try{
            int row = notifyService.remove(id);
            if(row == 1){
                return Response.success();
            }
            return Response.error("无此数据");
        }catch (Exception e){
            return Response.error();
        }
    }

    @GetMapping(name="分页搜索", value="getList")
    @ResponseBody
    public Response getList(@RequestParam(name="pageIndex", defaultValue = "1")  int pageIndex,
                            @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(name="isActive", required = false, defaultValue = "10") int isActive,
                            @RequestParam(name="keyword", required = false) String keyword){
        Response res = notifyService.getList(pageIndex, pageSize, keyword, isActive);
        return res;
    }





}
