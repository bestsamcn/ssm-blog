package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Hot;
import me.bestsamcn.blog.services.HotService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
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
        if(name == null || name.trim().isEmpty()){
            return Response.error("名称必填");
        }
        if(name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("名称长度不能少于2或者大于16");
        }

        if(hotService.getByName(name) != null){
            return Response.error("名称已存在");
        }

        List<Hot> total = hotService.getList();
        String len = Tools.getConfigProperty("HOT_WORD_LENGTH");
        int lenValue = Integer.valueOf(len);
        if(total.size() >= lenValue){
            hotService.delete(total.get(lenValue-1).getId());
        }

        Hot hot = new Hot();
//        hot.setId(Tools.getUUID());
        hot.setHotCount(0);
        hot.setName(name);
        hot.setCreateTime(new Timestamp(new Date().getTime()));
        try {
            int row = hotService.add(hot);
            if(row == 1){
                return Response.success("添加成功");
            }
            return Response.success("添加失败");
        }catch (Exception e){
            Response.error();
            throw e;
        }
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    @LoginRequired
    public Response delete(@RequestParam("id") String id) throws Exception{
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        int row = hotService.delete(id);
        if(row != 0){
            return Response.success("删除成功");
        }
        return Response.error();
    }

    @GetMapping(name="查询", value="getById")
    @ResponseBody
    public Response getById(@RequestParam("id") String id) throws Exception{
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        Hot hot = hotService.getById(id);
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
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        if(name == null || name.trim().isEmpty() || name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("名称符合要求");
        }
        if(hotService.getByName(name) != null){
            return Response.error("名称已存在");
        }
        Hot hot = hotService.getById(id);
        if(hot == null){
            return Response.error("无此数据");
        }
        hot.setName(name);
        int row = hotService.edit(hot);
        if(row == 0){
            return Response.error("编辑失败");
        }
        return Response.success("编辑成功");
    }
}
