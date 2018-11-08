package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category>{
    public Category selectByName(String name);
    public List<Category> selectAll();
}