package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.BaseMapper;
import me.bestsamcn.blog.services.BaseService;

/**
 * @Author: Sam
 * @Date: 2018/11/6 22:50
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getMapper();

    public abstract int add(T model);

    public int delete(String id){
        return getMapper().deleteByPrimaryKey(id);
    }

    public abstract int edit(T model);

    public T getById(String id){
        return getMapper().selectByPrimaryKey(id);
    }
}