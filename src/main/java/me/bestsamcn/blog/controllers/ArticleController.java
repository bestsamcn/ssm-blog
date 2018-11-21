package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.enums.ArticleNumberType;
import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.models.AdminVo;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.models.ArticleVO;
import me.bestsamcn.blog.services.AdminService;
import me.bestsamcn.blog.services.ArticleService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: Sam
 * @Date: 2018/11/14 0:57
 */
@Controller("articleController")
@RequestMapping(name="文章模块", value="/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    AdminService adminService;

    @PostMapping(name="新增", value="add")
    @ResponseBody
    @LoginRequired
    public Response add(@RequestParam("categoryId") String categoryId,
                        @RequestParam("tagId") String tagId,
                        @RequestParam("title") String title,
                        @RequestParam("previewText") String previewText,
                        @RequestParam("content") String content,
                        @RequestParam("codeContent") String codeContent,
                        @RequestParam(name="poster", required = false, defaultValue = "") String poster,
                        @RequestParam(name="isPrivate", required = false, defaultValue = "PUBLIC") ArticleType isPrivate,
                        @CookieValue("JSESSIONID") String JSESSIONID){
        Admin admin = Tools.getAdmin(JSESSIONID);
        Response res = articleService.add(admin.getId(), categoryId, tagId, title, previewText, content, codeContent, poster, isPrivate);
        return res;
    }


    @GetMapping(name="查询", value="getById")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Response getById(@RequestParam("id") String id){
        if(!Tools.isId(id)){
            return Response.error("无此数据");
        }
        try{
            articleService.setNumber(id, ArticleNumberType.READ, true);
            ArticleVO article =  (ArticleVO) articleService.selectVOById(id);
            if(article != null){
                return Response.build(article);
            }
            return Response.error("无此数据");
        }catch (Exception e){
            return Response.error();
        }
    }
}
