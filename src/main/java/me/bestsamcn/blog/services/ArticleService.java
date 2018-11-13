package me.bestsamcn.blog.services;

import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.utils.Response;

/**
 * @Author: Sam
 * @Date: 2018/11/14 0:43
 */
public interface ArticleService extends BaseService<Article> {

    public Response add();
}
