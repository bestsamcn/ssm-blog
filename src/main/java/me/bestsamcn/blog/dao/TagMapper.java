package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Tag;

public interface TagMapper extends BaseMapper<Tag>{
    int insertSelective(Tag record);
    int updateByPrimaryKeySelective(Tag record);
}