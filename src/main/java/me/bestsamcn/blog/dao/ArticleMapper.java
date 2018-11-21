package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.models.ArticleVO;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper extends  BaseMapper<Article>{
    public ArticleVO selectVOByPrimaryKey(@Param("id") String id);
}