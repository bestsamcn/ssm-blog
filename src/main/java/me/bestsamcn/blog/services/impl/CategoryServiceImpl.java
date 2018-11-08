package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.CategoryMapper;
import me.bestsamcn.blog.models.Category;
import me.bestsamcn.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/8 20:07
 */

@Service("CategoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryMapper getMapper(){
        return categoryMapper;
    }

    @Override
    public Category getByName(String name){
        return getMapper().selectByName(name);
    }

    @Override
    public List<Category> getList(){
        return getMapper().selectAll();
    }
}
