package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Tag;

/**
 * @Author: Sam
 * @Date: 2018/11/6 22:58
 */
public interface BaseMapper<T> {

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 增加
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 通过id获取单条记录
     * @param id
     * @return
     */
    T selectByPrimaryKey(String id);



    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);
}
