package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.bestsamcn.blog.dao.ArticleMapper;
import me.bestsamcn.blog.enums.ArticleNumberType;
import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.models.Article;
import me.bestsamcn.blog.models.ArticleVO;
import me.bestsamcn.blog.services.ArticleService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/11/14 0:48
 */
@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    protected ArticleMapper getMapper() {
        return articleMapper;
    }

    @Override
    public Response add(String creatorId, String categoryId, String tagId, String title, String previewText, String content, String codeContent, String poster,
                        ArticleType isPrivate) throws Exception {
        Timestamp now = Tools.getTimestamp();
        Article article = new Article();
        article.setId(Tools.getUUID());
        article.setTagId(tagId);
        article.setCategoryId(categoryId);
        article.setTitle(title);
        article.setContent(content);
        article.setCodeContent(codeContent);
        article.setCreatorId(creatorId);
        article.setCreateTime(now);
        article.setLastEditTime(now);
        article.setIsPrivate(isPrivate);
        article.setReadNum(0);
        article.setThumbnail("");
        article.setLikeNum(0);
        article.setPinyin(Tools.getPinyin(title));
        article.setPreviewText(previewText);
        article.setCommentNum(0);
        try{
            int row = getMapper().insert(article);
            if(row == 1){
                return Response.success();
            }
            return Response.error();
        }catch (Exception e){
            return Response.error();
        }
    }

    @Override
    public Response edit(String id, String categoryId, String tagId, String title, String previewText, String content, String codeContent,
                         String poster,
                        ArticleType isPrivate) {
        if(!Tools.isId(id)){
            return Response.error("无此数据");
        }

        try{
            Article article = this.getMapper().selectByPrimaryKey(id);
            if(article == null){
                return Response.error("无此数据");
            }
            if(categoryId != null && !categoryId.equals("")){
                article.setCategoryId(categoryId);
            }else{
                return Response.error("分类不能为空");
            }
            if(tagId != null && !tagId.isEmpty()){
                article.setTagId(tagId);
            }else{
                return Response.error("标签不能为空");
            }
            if(title !=null && !title.isEmpty()){
                article.setTitle(title);
                article.setPinyin(Tools.getPinyin(title));
            }else{
                return Response.error("标题不能为空");
            }
            if(previewText !=null){
                article.setPreviewText(previewText);
            }
            if(content !=null && !content.isEmpty()){
                article.setContent(content);
            }else{
                return Response.error("内容不能为空");
            }
            if(codeContent != null && !codeContent.isEmpty()){
                article.setCodeContent(codeContent);
            }else{
                return Response.error("内容不能为空");
            }
            if(poster !=null){
                article.setPoster(poster);
            }
            if(isPrivate !=null){
                article.setIsPrivate(isPrivate);
            }
            article.setLastEditTime(Tools.getTimestamp());
            int row = this.getMapper().updateByPrimaryKey(article);
            if(row == 1){
                return Response.success("编辑成功");
            }
            return Response.error("编辑失败");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }

    @Override
    public ArticleVO selectVOById(String id){
        return this.getMapper().selectVOByPrimaryKey(id);
    }


    @Override
    public int setNumber(String id, ArticleNumberType type, boolean isPlus){
        if(!Tools.isId(id)){
            return 0;
        }try {
            Article article =  this.getMapper().selectByPrimaryKey(id);
            if(article == null){
                return 0;
            }
            if(type.getKey() !=null){
                StringBuilder methodName = new StringBuilder().append(Character.toUpperCase(type.getKey().charAt(0))).append(type.getKey().substring(1));
                Method setMethod = article.getClass().getMethod("set"+methodName.toString(), Integer.class);
                Method getMethod = article.getClass().getMethod("get"+methodName.toString());
                int oldNum = (Integer) getMethod.invoke(article);
                if(isPlus){
                    oldNum = oldNum+1;
                }else{
                    oldNum = oldNum-1;
                }
                setMethod.invoke(article,oldNum);
                return this.getMapper().updateByPrimaryKey(article);
            }
            return 0;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Response getList(int pageIndex, int pageSize, String keyword, ArticleType type, String orderName){
        if(pageIndex < 0 || pageSize < 0){
            return Response.error("分页参数不正确");
        }
        orderName = Tools.toUnderLine(orderName);
        try{
            PageHelper.startPage(pageIndex, pageSize);
            List<ArticleVO> list = this.getMapper().selectAll(orderName, keyword, type.getKey());
            PageInfo<ArticleVO> pageInfo = new PageInfo(list, pageSize);
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

}
