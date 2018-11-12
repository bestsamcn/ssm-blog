package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Logit;
import me.bestsamcn.blog.utils.Response;

/**
 * @Author: Sam
 * @Date: 2018/11/12 22:14
 */
public interface LogitService extends BaseService<Logit>{
    /**
     * 获取分页
     * @param pageIndex
     * @param pageSize
     * @param type
     * @param keyword
     * @return
     */
    public Response getList(int pageIndex, int pageSize, int type, String keyword);
}
