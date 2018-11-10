package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Message;
import me.bestsamcn.blog.utils.Response;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/10 21:26
 */

public interface MessageService extends BaseService<Message>{

    /**
     * 添加
     * @param name
     * @param email
     * @param content
     * @return
     */
    public Response add(String name, String email, String content);

    /**
     * 获取分页
     * @param pageIndex
     * @param pageSize
     * @param type
     * @param keyword
     * @return
     */
    public Response getList(int pageIndex, int pageSize, String type, String keyword);
}
