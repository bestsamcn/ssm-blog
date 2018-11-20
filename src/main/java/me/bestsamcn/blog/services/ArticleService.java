package me.bestsamcn.blog.services;

import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.utils.Response;

/**
 * @Author: Sam
 * @Date: 2018/11/14 0:43
 */
public interface ArticleService extends BaseService<Article> {


    /**
     * 添加
     * @param creatorId
     * @param categoryId
     * @param tagId
     * @param title
     * @param previewText
     * @param content
     * @param codeContent
     * @param poster
     * @param isPrivate
     * @return
     */
    public Response add(String creatorId, String categoryId, String tagId, String title, String previewText, String content, String codeContent, String poster,
                        ArticleType isPrivate);
}
