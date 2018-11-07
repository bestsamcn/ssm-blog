package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper extends BaseMapper<Tag>{
    int insertSelective(Tag record);
    int updateByPrimaryKeySelective(Tag record);
}