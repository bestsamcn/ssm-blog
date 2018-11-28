package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.bestsamcn.blog.dao.BaseMapper;
import me.bestsamcn.blog.dao.CommentMapper;
import me.bestsamcn.blog.enums.CommentStatus;
import me.bestsamcn.blog.models.Comment;
import me.bestsamcn.blog.models.CommentTreeVO;
import me.bestsamcn.blog.services.CommentService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/11/27 20:50
 */

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    protected CommentMapper getMapper() {
        return commentMapper;
    }

    @Override
    public Response add(String articleId, String content, String createName, String createEmail, String parentId, String createIp) {
        if(!Tools.isId(articleId)){
            return Response.error("无此文章");
        }
        if(parentId != null && !parentId.trim().isEmpty() && !Tools.isId(parentId)){
            return Response.error("无此父级评论");
        }
        if(content == null || content.trim().isEmpty()){
            return Response.error("内容不能为空");
        }
        String nameError = Tools.assertString(createName, 3, 24, "昵称");
        if(nameError != null){
            return Response.error(nameError);
        }
        if(createEmail != null && !Tools.isMatch("[\\w]+@\\w+\\.\\w+", createEmail)){
            return Response.error("邮箱格式错误");
        }

        Comment comment = new Comment();
        comment.setId(Tools.getUUID());
        comment.setArticleId(articleId);
        comment.setParentId(parentId);
        comment.setContent(content);
        comment.setCreateName(createName);
        comment.setCreateEmail(createEmail);
        comment.setCreateIp(createIp);
        comment.setCreateTime(Tools.getTimestamp());
        comment.setStatus(CommentStatus.ALL);
        comment.setLikeNum(0);
        try {
            int row = this.getMapper().insert(comment);
            if(row == 1){
                return Response.success("添加成功");
            }
            return Response.error("添加失败");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }

    @Override
    public Response edit(String commentId, String content) {
        if(!Tools.isId(commentId)){
            return Response.error("无此评论");
        }
        if(content == null || content.trim().isEmpty()){
            return Response.error("内容不能为空");
        }

        try {
            Comment comment = this.getMapper().selectByPrimaryKey(commentId);
            if(comment == null){
                return Response.error("无此数据");
            }
            comment.setContent(content);
            int row = this.getMapper().updateByPrimaryKey(comment);
            if(row == 1){
                return Response.success("更新成功");
            }
            return Response.error("更新失败");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }

    @Override
    public Response getList(int pageIndex, int pageSize, CommentStatus type, String keyword) {
        if(pageIndex < 0 || pageSize < 0){
            return Response.error("分页参数不正确");
        }
        try{
            PageHelper.startPage(pageIndex, pageSize);
            List<Comment> list = this.getMapper().selectAll(type.getKey(), keyword);
            PageInfo<Comment> pageInfo = new PageInfo(list, pageSize);
            Map<String, Object> map= new HashMap();
            map.put("list", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
            map.put("pageIndex", pageInfo.getPageNum());
            map.put("pageSize", pageInfo.getPageSize());
            return Response.build(map);
        }catch(Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }
    @Override
    public Response getTree(){
        try{
            List<Object> list = this.getMapper().selectTree();
            return Response.build(list);
        }catch(Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }
}
