package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Hot;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/8 20:48
 */
public interface HotService extends BaseService<Hot>{

    /**
     * 通过名称获取
     * @param name
     * @return
     */
    public Hot getByName(String name);

    /**
     * 获取列表
     * @return
     */
    public List<Hot> getList();
}
