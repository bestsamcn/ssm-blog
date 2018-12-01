package me.bestsamcn.blog.services;

import me.bestsamcn.blog.enums.ArticleNumberType;
import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.models.ArticleVO;
import me.bestsamcn.blog.utils.Response;

import java.util.List;

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
                        ArticleType isPrivate) throws Exception;


    /**
     * 添加
     * @param id
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
    public Response edit(String id, String categoryId, String tagId, String title, String previewText, String content, String codeContent,
                         String poster,
                        ArticleType isPrivate);

    /**
     * 数量设置
     * @param id
     * @param type
     * @param isPlus
     * @return
     */
    public int setNumber(String id, ArticleNumberType type, boolean isPlus);

    /**
     * 关联查询
     * @param id
     * @return
     */
    public ArticleVO selectVOById(String id);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @param keyword
     * @param type
     * @param orderName
     * @return
     */
    public Response getList(int pageIndex, int pageSize, String keyword, ArticleType type, String orderName);
}
