package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.TagMapper;
import me.bestsamcn.blog.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Sam
 * @Date: 2018/11/6 23:25
 */
public class TagServiceImpl extends BaseServiceImpl<Tag>{

    @Autowired
    TagMapper tagMapper;

    public TagMapper getMapper(){
        return tagMapper;
    }

    public int add(Tag tag){
        return 0;
    }

    public int edit(Tag tag){
        return 0;
    }
}
