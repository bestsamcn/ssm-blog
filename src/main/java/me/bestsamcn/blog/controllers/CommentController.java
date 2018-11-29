package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.enums.ArticleNumberType;
import me.bestsamcn.blog.enums.CommentStatus;
import me.bestsamcn.blog.models.ArticleVO;
import me.bestsamcn.blog.models.Comment;
import me.bestsamcn.blog.services.CommentService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Sam
 * @Date: 2018/11/27 21:32
 */
@Controller("CommentController")
@RequestMapping(name="评论模块", value="/comment")
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping(name="新增", value="add")
    @ResponseBody
    public Response add(@RequestParam("articleId") String articleId,
                        @RequestParam("content") String content,
                        @RequestParam("createName") String createName,
                        @RequestParam("createEmail") String createEmail,
                        @RequestParam(name="parentId", required = false) String parentId,
                        HttpServletRequest httpServletRequest) throws Exception{
        String IP = Tools.getIp(httpServletRequest);
        return commentService.add(articleId, content, createName, createEmail, parentId, IP);
    }

    @PostMapping(name="编辑", value="edit")
    @ResponseBody
    public Response add(@RequestParam("commentId") String commentId,
                        @RequestParam("content") String content){
        return commentService.edit(commentId, content);
    }

    @GetMapping(name="查询", value="getById")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Response getById(@RequestParam("id") String id){
        if(!Tools.isId(id)){
            return Response.error("无此数据");
        }
        try{
            Comment comment = commentService.selectById(id);
            if(comment != null){
                return Response.build(comment);
            }
            return Response.error("无此数据");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }

    @PostMapping(name="删除", value="delete")
    @ResponseBody
    @LoginRequired
    public  Response delete(@RequestParam("id") String id){
        if(!Tools.isId(id)){
            return Response.error("无此数据");
        }
        try {
            int row = commentService.remove(id);
            if(row == 1){
                return Response.success("删除成功");
            }
            return Response.error("无此数据");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }

    @GetMapping(name="分页", value="getList")
    @ResponseBody
    public Response getList(@RequestParam(name="pageIndex", defaultValue = "1") int pageIndex,
                            @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(name="type", required = false, defaultValue = "ALL") CommentStatus type,
                            @RequestParam(name="keyword", required = false) String keyword){
        return commentService.getList(pageIndex, pageSize, type, keyword);
    }

    @GetMapping(name="树", value="getTree")
    @ResponseBody
    public Response getTree(){
        return commentService.getTreeList();
    }
}
