package me.bestsamcn.blog.models;

import java.util.Date;

public class Hot {
    private String id;

    private String name;

    private Date createTime;

    private Integer hotCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }
}