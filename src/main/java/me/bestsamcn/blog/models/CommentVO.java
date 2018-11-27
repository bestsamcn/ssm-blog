package me.bestsamcn.blog.models;

/**
 * @Author: Sam
 * @Date: 2018/11/27 23:18
 */
public class CommentVO extends Comment{

    private Article article;
    private Comment parent;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }
}
