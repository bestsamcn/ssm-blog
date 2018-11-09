package me.bestsamcn.blog.services;

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
    public T selectById(String id);

    /**
     * 新增
     * @param model
     * @return
     */
    public int insert(T model);

    /**
     * 删除
     * @param id
     * @return
     */
    public int remove(String id);

    /**
     * 修改
     * @param model
     * @return
     */
    public int update(T model);
}
