package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.BaseMapper;
import me.bestsamcn.blog.services.BaseService;
import org.springframework.stereotype.Repository;

/**
 * @Author: Sam
 * @Date: 2018/11/6 22:50
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getMapper();

    public int add(T model){
        return getMapper().insert(model);
    };

    public int delete(String id){
        return getMapper().deleteByPrimaryKey(id);
    }

    public  int edit(T model){
        return getMapper().updateByPrimaryKey(model);
    }

    public T getById(String id){
        return getMapper().selectByPrimaryKey(id);
    }
}
