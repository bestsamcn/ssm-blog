package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Logit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogitMapper extends BaseMapper<Logit> {
    public List<Logit> selectAll(@Param("orderName") String orderName, @Param("keyword") String keyword, @Param("type") int type);
}