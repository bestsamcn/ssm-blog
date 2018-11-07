package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Tag;
import me.bestsamcn.blog.services.TagService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;

@Controller("tagController")
@RequestMapping(name="标签模块", value="/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping(name="添加标签", value="add")
    @ResponseBody
    public Response add(@RequestParam("name") String name) throws Exception{
        if(name == null || name.trim().isEmpty()){
            return Response.error("标签名必填");
        }
        if(name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("标签名长度不能少于2或者大于16");
        }
        Tag tag = new Tag();
        tag.setClickNum(0);
        tag.setName(name);
        tag.setCreateTime(new Timestamp(new Date().getTime()));
        int row = tagService.add(tag);
        if(row == 1){
            return Response.success("添加成功");
        }
        return Response.error();
    }
}
