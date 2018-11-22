package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.bestsamcn.blog.dao.NotifyMapper;
import me.bestsamcn.blog.enums.MessageType;
import me.bestsamcn.blog.enums.NotifyType;
import me.bestsamcn.blog.models.Message;
import me.bestsamcn.blog.models.Notify;
import me.bestsamcn.blog.services.NotifyService;
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
 * @Date: 2018/11/11 20:29
 */
@Service("notifyService")
public class NotifyServiceImpl extends BaseServiceImpl<Notify> implements NotifyService {

    @Autowired
    NotifyMapper notifyMapper;

    @Override
    public Response add(String content, long expireTime, int isActive) {
        String contMsg = Tools.assertString(content, 6, 250, "内容");
        if(contMsg != null){
            return Response.error(contMsg);
        }
        String expTime =  String.valueOf(expireTime);
        if(expTime.trim().length() != 13){
            return Response.error("时间格式错误");
        }

        if(NotifyType.getEnum(isActive) == null){
            return Response.error("状态类型错误");
        }

        Timestamp createTime = new Timestamp(new Date().getTime());
        Notify notify = new Notify();
        notify.setId(Tools.getUUID());
        notify.setContent(content);
        notify.setCreateTime(createTime);
        notify.setIsActive(isActive);
        notify.setLastEditTime(createTime);
        notify.setExpireTime(new Timestamp(expireTime));
        try{
            int row = getMapper().insert(notify);
            if(row == 1){
                return Response.success("新增成功");
            }
            return Response.error("新增失败");
        }catch (Exception e){
            return Response.error();
        }
    }

    @Override
    public Response edit(String id, String content, long expireTime, int isActive) {
        String idMsg = Tools.assertString(id, 32, 32, "id");
        String contMsg = Tools.assertString(content, 6, 250, "内容");
        String expTime =  String.valueOf(expireTime);
        if(idMsg != null){
            return Response.error("无此数据");
        }
        if(contMsg != null){
            return Response.error(contMsg);
        }
        if(expTime.trim().length() != 13){
            return Response.error("时间格式错误");
        }
        if(NotifyType.getEnum(isActive) == null){
            return Response.error("状态类型错误");
        }
        try{
            Notify notify = getMapper().selectByPrimaryKey(id);
            if(notify == null){
                return Response.error("无此数据");
            }
            notify.setExpireTime(new Timestamp(expireTime));
            notify.setLastEditTime(new Timestamp(new Date().getTime()));
            notify.setContent(content);
            notify.setIsActive(isActive);
            int row = getMapper().insert(notify);
            if(row == 1){
                return Response.success("编辑成功");
            }
            return Response.error("编辑失败");
        }catch (Exception e){
            return Response.error();
        }
    }

    @Override
    public Response getList(int pageIndex, int pageSize, String keyword, int isActive) {
        if(pageIndex < 0 || pageSize < 0){
            return Response.error("分页参数不正确");
        }
        try{
            PageHelper.startPage(pageIndex, pageSize);
            List<Notify> list = getMapper().selectAll("last_edit_time", keyword, NotifyType.getEnum(isActive).getKey());
            PageInfo<Notify> pageInfo = new PageInfo(list, pageSize);
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

    protected NotifyMapper getMapper() {
        return notifyMapper;
    }
}
