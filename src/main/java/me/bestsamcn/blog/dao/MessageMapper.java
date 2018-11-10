package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper extends BaseMapper<Message>{

    List<Message> selectAll(@Param("orderName") String orderName);
}