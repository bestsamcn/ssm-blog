package me.bestsamcn.blog.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.bestsamcn.blog.dao.BaseMapper;
import me.bestsamcn.blog.dao.LogitMapper;
import me.bestsamcn.blog.enums.LogitType;
import me.bestsamcn.blog.enums.NotifyType;
import me.bestsamcn.blog.models.Logit;
import me.bestsamcn.blog.models.Notify;
import me.bestsamcn.blog.services.LogitService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/11/12 22:16
 */
@Service("LogitService")
public class LogitServiceImpl extends BaseServiceImpl<Logit> implements LogitService {
    @Autowired
    LogitMapper logitMapper;
    @Override
    protected LogitMapper getMapper() {
        return logitMapper;
    }

    @Override
    public Response getList(int pageIndex, int pageSize, int type, String keyword) {
        if(pageIndex < 0 || pageSize < 0){
            return Response.error("分页参数不正确");
        }
        try{
            PageHelper.startPage(pageIndex, pageSize);
            List<Logit> list = getMapper().selectAll("create_time", keyword, LogitType.getEnum(type).getKey());
            PageInfo<Logit> pageInfo = new PageInfo(list, pageSize);
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
}
