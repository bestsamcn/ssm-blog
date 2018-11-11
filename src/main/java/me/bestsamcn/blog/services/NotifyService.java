package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Notify;
import me.bestsamcn.blog.utils.Response;

/**
 * @Author: Sam
 * @Date: 2018/11/11 20:24
 */
public interface NotifyService extends BaseService<Notify>{

    /**
     * 新增
     * @param content
     * @param expireTime
     * @param isActive
     * @return
     */
    public Response add(String content,  long expireTime, int isActive);

    /**
     * 编辑
     * @param id
     * @param content
     * @param expireTime
     * @param isActive
     * @return
     */
    public Response edit(String id, String content, long expireTime, int isActive);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @param keyword
     * @param isActive
     * @return
     */
    public Response getList(int pageIndex, int pageSize, String keyword, int isActive);

}
