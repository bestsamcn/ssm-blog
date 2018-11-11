package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Notify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyMapper extends BaseMapper<Notify>{
    List<Notify> selectAll(@Param("orderName") String orderName, @Param("keyword") String keyword, @Param("isActive") int isActive);
}