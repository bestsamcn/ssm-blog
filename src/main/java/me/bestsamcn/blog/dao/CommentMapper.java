package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper extends BaseMapper<Comment>{

    public List<Comment> selectAll(@Param("type") int type, @Param("keyword") String keyword);

    public List<Object> selectTree();
    public List<Object> selectChildren(@Param("id") String id);
}