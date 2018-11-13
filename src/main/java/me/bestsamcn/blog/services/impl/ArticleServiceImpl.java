package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.ArticleMapper;
import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.services.ArticleService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: Sam
 * @Date: 2018/11/14 0:48
 */
@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    protected ArticleMapper getMapper() {
        return articleMapper;
    }

    @Override
    public Response add() {

        Article article = new Article();
        article.setId(Tools.getUUID());
        article.setTag("384fd2004113489293138ae184b9f56d");
        article.setCategory("6707a21a308a40f19bb850f9302f92b7");
        article.setContent("我是是中国国人");
        article.setCreator("77a7e4b88b404d09bd5ee9bace3825af");
        article.setCreateTime(new Timestamp(new Date().getTime()));
        article.setLastEditTime(new Timestamp(new Date().getTime()));
        article.setIsPrivate(ArticleType.Public);
        article.setReadNum(0);
        article.setThumbnail("adfas");
        article.setLikeNum(0);
        article.setPreviewText("alksdfasf");
        article.setCodeContent("Sdfsadf");
        article.setCommentNum(0);
        article.setTitle("sldfalsdfj");
        try{
            int row = getMapper().insert(article);
            if(row == 1){
                return Response.success();
            }
            return Response.error();
        }catch (Exception e){
            return Response.error();
        }
    }
}
