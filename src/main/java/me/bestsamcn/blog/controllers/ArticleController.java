package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.services.ArticleService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
