package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.utils.Response;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:56
 */
public interface AdminService {

    /**
     * 通过id获取
     * @param id
     * @return
     */
    public Admin getById(String id);

    /**
     * 新增
     * @param account
     * @param password
     * @return
     */
    public Response add(String account, String password);

    /**
     * 删除
     * @param id
     * @return
     */
    public Response delete(String id);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Response getList(int pageIndex, int pageSize);
}
