package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Category;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/8 20:04
 */
public interface CategoryService extends BaseService<Category>{

    /**
     * 通过名称获取
     * @param name
     * @return
     */
    public Category getByName(String name);

    /**
     * 获取全部列表
     * @return
     */
    public List<Category> getList();
}
