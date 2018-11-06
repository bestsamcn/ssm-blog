package me.bestsamcn.blog.services;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/6 22:34
 */
public interface BaseService<T> {
    /**
     * 通过id获取
     * @param id
     * @return
     */
    public T getById(String id);

    /**
     * 新增
     * @param model
     * @return
     */
    public int add(T model);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 修改
     * @param model
     * @return
     */
    public int edit(T model);
}
