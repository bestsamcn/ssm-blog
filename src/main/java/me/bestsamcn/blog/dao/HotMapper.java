package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Hot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotMapper extends BaseMapper<Hot>{

    public Hot selectByName(String name);
    public List<Hot> selectAll();
}