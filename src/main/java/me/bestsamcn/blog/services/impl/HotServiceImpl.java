package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.HotMapper;
import me.bestsamcn.blog.models.Hot;
import me.bestsamcn.blog.services.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/8 20:50
 */
@Service("hotService")
public class HotServiceImpl extends BaseServiceImpl<Hot> implements HotService {

    @Autowired
    HotMapper hotMapper;

    public HotMapper getMapper(){
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
}
