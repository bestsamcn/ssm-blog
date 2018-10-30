package me.bestsamcn.blog.dao;

import me.bestsamcn.blog.models.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}