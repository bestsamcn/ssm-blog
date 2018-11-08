package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Hot;

import java.util.List;

public interface HotMapper extends BaseMapper<Hot>{

    public Hot selectByName(String name);
    public List<Hot> selectAll();
}