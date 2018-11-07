package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Tag;
import me.bestsamcn.blog.services.TagService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller("tagController")
@RequestMapping(name="标签模块", value="/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping(name="添加", value="add")
    @ResponseBody
    @LoginRequired
    public Response add(@RequestParam("name") String name) throws Exception{
        if(name == null || name.trim().isEmpty()){
            return Response.error("标签名必填");
        }
        if(name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("标签名长度不能少于2或者大于16");
        }

        if(tagService.getByName(name) != null){
            return Response.error("标签名已存在");
        }

        Tag tag = new Tag();
        tag.setId(Tools.getUUID());
        tag.setClickNum(0);
        tag.setName(name);
        tag.setCreateTime(new Timestamp(new Date().getTime()));
        int row = tagService.add(tag);
        if(row == 1){
            return Response.success("添加成功");
        }
        return Response.error();
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    @LoginRequired
    public Response delete(@RequestParam("id") String id) throws Exception{
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        int row = tagService.delete(id);
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
        Tag tag = tagService.getById(id);
        if(tag != null){
            return Response.build(tag);
        }
        return Response.error();
    }

    @GetMapping(name="查询", value="getList")
    @ResponseBody
    public Response getList() throws Exception{
        List<Tag> tagList = tagService.getList();
        return Response.build(tagList);
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
        if(tagService.getByName(name) != null){
            return Response.error("标签名已存在");
        }
        Tag tag = tagService.getById(id);
        if(tag == null){
            return Response.error("无此数据");
        }
        tag.setName(name);
        int row = tagService.edit(tag);
        if(row == 0){
            return Response.error("编辑失败");
        }
        return Response.success("编辑成功");
    }


}
