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
    public Response add(String creatorId, String categoryId, String tagId, String title, String previewText, String content, String codeContent, String poster,
                        ArticleType isPrivate) {
        Timestamp now = Tools.getTimestamp();
        Article article = new Article();
        article.setId(Tools.getUUID());
        article.setTagId(tagId);
        article.setCategoryId(categoryId);
        article.setTitle(title);
        article.setContent(content);
        article.setCodeContent(codeContent);
        article.setCreatorId(creatorId);
        article.setCreateTime(now);
        article.setLastEditTime(now);
        article.setIsPrivate(isPrivate);
        article.setReadNum(0);
        article.setThumbnail("");
        article.setLikeNum(0);
        article.setPreviewText(previewText);
        article.setCommentNum(0);
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
