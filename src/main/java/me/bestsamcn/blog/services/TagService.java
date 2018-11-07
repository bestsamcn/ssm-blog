package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Tag;

import java.util.List;

public interface TagService extends BaseService<Tag>{

    /**
     * 通过名称获取数据
     * @param name
     * @return
     */
    public Tag getByName(String name);

    /**
     * 获取列表
     * @return
     */
    public List<Tag> getList();
}
