package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.models.Notify;
import me.bestsamcn.blog.services.ArticleService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Sam
 * @Date: 2018/11/14 0:57
 */
@Controller("articleController")
@RequestMapping(name="文章模块", value="/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping(name="新增", value="add")
    @ResponseBody
    public Response add(){
        Response res = articleService.add();
        return res;
    }

    @GetMapping(name="查询", value="getById")
    @ResponseBody
    public Response getById(){
        try{
            Article article = articleService.selectById("24fe562b9a794727afbbfbd1d2d09b6d");
            if(article != null){
                return Response.build(article);
            }
            return Response.error("无此数据");
        }catch (Exception e){
            return Response.error();
        }
    }
}
