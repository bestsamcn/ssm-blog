package me.bestsamcn.blog.models;

import java.sql.Timestamp;
import java.util.List;

public class CommentTreeVO {
    private String id;
    private String createName;
    private String createEmail;
    private Timestamp createTime;

    private List<CommentTreeVO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateEmail() {
        return createEmail;
    }

    public void setCreateEmail(String createEmail) {
        this.createEmail = createEmail;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<CommentTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<CommentTreeVO> children) {
        this.children = children;
    }
}
