package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.HotMapper;
import me.bestsamcn.blog.models.Hot;
import me.bestsamcn.blog.services.HotService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/8 20:50
 */
@Service("hotService")
public class HotServiceImpl extends BaseServiceImpl<Hot> implements HotService {

    @Autowired
    HotMapper hotMapper;

    protected HotMapper getMapper(){
        return hotMapper;
    }

    @Override
    public Hot getByName(String name) {
        return getMapper().selectByName(name);
    }

    @Override
    public List<Hot> getList() {
        return getMapper().selectAll();
    }

    @Override
    @Transactional
    public Response add(String name){
        if(name == null || name.trim().isEmpty()){
            return Response.error("名称必填");
        }
        if(name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("名称长度不能少于2或者大于16");
        }

        if(this.getByName(name) != null){
            return Response.error("名称已存在");
        }

        List<Hot> total = this.getList();
        String len = Tools.getConfigProperty("HOT_WORD_LENGTH");
        int lenValue = Integer.valueOf(len);
        if(total.size() >= lenValue){
            this.remove(total.get(lenValue-1).getId());
        }

        Hot hot = new Hot();
        hot.setId(Tools.getUUID());
        hot.setHotCount(0);
        hot.setName(name);
        hot.setCreateTime(new Timestamp(new Date().getTime()));
        try {
            int row = this.insert(hot);
            if(row == 1){
                return Response.success("添加成功");
            }
            return Response.success("添加失败");
        }catch (Exception e){
            Response.error();
        }
        return Response.error();
    }

    @Override
    public Response delete(String id){
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        int row = this.remove(id);
        if(row != 0){
            return Response.success("删除成功");
        }
        return Response.error();
    }

    @Override
    public Response edit(String id, String name){
        if(id == null || id.trim().isEmpty() || id.trim().length() !=32){
            return Response.error("无此数据");
        }
        if(name == null || name.trim().isEmpty() || name.trim().length() < 2 || name.trim().length() > 16){
            return Response.error("名称符合要求");
        }
        if(this.getByName(name) != null){
            return Response.error("名称已存在");
        }
        Hot hot = this.selectById(id);
        if(hot == null){
            return Response.error("无此数据");
        }
        hot.setName(name);
        int row = this.update(hot);
        if(row == 0){
            return Response.error("编辑失败");
        }
        return Response.success("编辑成功");
    }
}
