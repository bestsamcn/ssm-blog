package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.models.ArticleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends  BaseMapper<Article>{

    /**
     * 关联查询
     * @param id
     * @return
     */
    public ArticleVO selectVOByPrimaryKey(@Param("id") String id);

    /**
     * 分页关联查询
     * @param keyword
     * @param type
     * @param orderName
     * @return
     */
    public List<ArticleVO> selectAll(@Param("orderName") String orderName, @Param("keyword") String keyword, @Param("isPrivate") int type);
}