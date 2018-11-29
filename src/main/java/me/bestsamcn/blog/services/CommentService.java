package me.bestsamcn.blog.services;

import me.bestsamcn.blog.enums.CommentStatus;
import me.bestsamcn.blog.models.Comment;
import me.bestsamcn.blog.utils.Response;

/**
 * @Author: Sam
 * @Date: 2018/11/27 20:43
 */
public interface CommentService extends BaseService<Comment>{

    /**
     * 新增
     * @param articleId
     * @param content
     * @param createName
     * @param createEmail
     * @param parentId
     * @param createIp
     * @return
     */
    public Response add(String articleId, String content, String createName, String createEmail, String parentId, String createIp);

    /**
     * 编辑
     * @param commentId
     * @param content
     * @return
     */
    public Response edit(String commentId, String content);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @param type
     * @param keyword
     * @return
     */
    public Response getList(int pageIndex, int pageSize, CommentStatus type, String keyword);

    /**
     * 树形结构
     * @param articleId
     * @return
     */
    public Response getTreeList(String articleId);
}
