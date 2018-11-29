package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper extends BaseMapper<Comment>{

    /**
     *  获取全部
     * @param type
     * @param keyword
     * @return
     */
    public List<Comment> selectAll(@Param("type") int type, @Param("keyword") String keyword);

    /**
     * 获取根节点集合
     * @param articleId
     * @return
     */
    public List<Object> selectTreeRootList(@Param("articleId") String articleId);

    /**
     * 获取子点集合
     * @param id
     * @return
     */
    public List<Object> selectTreeChildren(@Param("id") String id);
}