package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Category;
import me.bestsamcn.blog.services.CategoryService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller("categoryController")
@RequestMapping(name="分类模块", value="/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(name="添加", value="add")
    @ResponseBody
    @LoginRequired
    public Response add(@RequestParam("name") String name) throws Exception{
        if(name == null || name.trim().isEmpty()){
            return Response.error("名称必填");
        }
        if(name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("名长度不能少于2或者大于16");
        }

        if(categoryService.getByName(name) != null){
            return Response.error("名称已存在");
        }

        Category category = new Category();
        category.setId(Tools.getUUID());
        category.setClickNum(0);
        category.setName(name);
        category.setCreateTime(new Timestamp(new Date().getTime()));
        int row = categoryService.add(category);
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
        int row = categoryService.delete(id);
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
        Category category = categoryService.getById(id);
        if(category != null){
            return Response.build(category);
        }
        return Response.error();
    }

    @GetMapping(name="查询", value="getList")
    @ResponseBody
    public Response getList() throws Exception{
        List<Category> list = categoryService.getList();
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
        if(categoryService.getByName(name) != null){
            return Response.error("标签名已存在");
        }
        Category category = categoryService.getById(id);
        if(category == null){
            return Response.error("无此数据");
        }
        category.setName(name);
        int row = categoryService.edit(category);
        if(row == 0){
            return Response.error("编辑失败");
        }
        return Response.success("编辑成功");
    }
}
