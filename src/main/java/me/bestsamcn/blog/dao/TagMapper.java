package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper extends BaseMapper<Tag>{
    int insertSelective(Tag record);
    int updateByPrimaryKeySelective(Tag record);
    /**
     * 通过字段名称获取
     * @param name
     * @return
     */
    Tag selectByName(String name);

    /**
     * 获取列表
     * @return
     */
    List<Tag> selectAll();
}