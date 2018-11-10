package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.bestsamcn.blog.dao.MessageMapper;
import me.bestsamcn.blog.enums.MessageType;
import me.bestsamcn.blog.models.Message;
import me.bestsamcn.blog.services.MessageService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/11/10 21:28
 */
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    public MessageMapper getMapper(){
        return messageMapper;
    }

    @Override
    public Response getList(int pageIndex, int pageSize, int type, String keyword) {
        if(pageIndex < 0 || pageSize < 0){
            return Response.error("分页参数不正确");
        }
        try{
            PageHelper.startPage(pageIndex, pageSize);
            List<Message> list = getMapper().selectAll("post_time", keyword, MessageType.getEnum(type).getKey());
            PageInfo<Message> pageInfo = new PageInfo(list, pageSize);
            Map<String, Object> map= new HashMap();
            map.put("list", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
            map.put("pageIndex", pageInfo.getPageNum());
            map.put("pageSize", pageInfo.getPageSize());
            return Response.build(map);
        }catch(Exception e){
            return Response.error();
        }
    }

    @Override
    public Response add(String name, String email, String content){
        if(name == null || name.trim().isEmpty()){
            return Response.error("昵称不能为空");
        }
        if(name.trim().length() < 3 || name.trim().length() > 24){
            return Response.error("昵称长度不能小于3或者大于24");
        }
        if(email == null || email.trim().isEmpty()){
            return Response.error("邮箱不能为空");
        }
        if(!Tools.isMatch("^\\w+[@]\\w+\\.\\w+$", email)){
           return Response.error("邮箱格式不正确");
        }
        if(content == null || content.trim().isEmpty()){
            return Response.error("内容不能为空");
        }
        if(content.length() < 2 || content.length() > 250){
            return Response.error("内容长度不能小于2或者大于250");
        }

        Message message = new Message();
        message.setId(Tools.getUUID());
        message.setName(name);
        message.setEmail(email);
        message.setContent(content);
        message.setIsRead(10);
        message.setPostTime(new Timestamp(new Date().getTime()));
        try {
            int row = getMapper().insert(message);
            if(row == 1){
                return Response.success("添加成功");
            }
            return Response.error("添加失败");
        }catch (Exception e){
            return Response.error();
        }
    }
}
