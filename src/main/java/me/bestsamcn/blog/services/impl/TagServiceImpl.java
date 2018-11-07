package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.TagMapper;
import me.bestsamcn.blog.models.Tag;
import me.bestsamcn.blog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Sam
 * @Date: 2018/11/6 23:25
 */
@Service("tagService")
public class TagServiceImpl extends BaseServiceImpl<Tag> implements TagService {

    @Autowired
    TagMapper tagMapper;

    public TagMapper getMapper(){
        return tagMapper;
    }

    public int add(Tag tag){
        return tagMapper.insert(tag);
    }

    public int edit(Tag tag){
        return 0;
    }
}
