package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.BaseMapper;
import me.bestsamcn.blog.dao.LogitMapper;
import me.bestsamcn.blog.models.Logit;
import me.bestsamcn.blog.services.LogitService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Sam
 * @Date: 2018/11/12 22:16
 */
@Service("LogitService")
public class LogitServiceImpl extends BaseServiceImpl<Logit> implements LogitService {
    @Autowired
    LogitMapper logitMapper;
    @Override
    protected BaseMapper<Logit> getMapper() {
        return logitMapper;
    }

    @Override
    public Response getList(int pageIndex, int pageSize, int type, String keyword) {
        return null;
    }
}
