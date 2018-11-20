package me.bestsamcn.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author: Sam
 * @Date: 2018/11/20 20:40
 */

@JsonIgnoreProperties(value = { "tagId", "categoryId", "creatorId" })
public class ArticleVO extends Article{
    private Admin admin;

    private Category category;
    private Tag tag;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
