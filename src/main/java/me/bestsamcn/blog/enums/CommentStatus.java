package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/11/27 20:32
 */
public enum CommentStatus {
    ALL(10, "全部"),
    PASS(20, "通过" ),
    REJECT(30, "拒绝");
    private int key;
    private String name;
    CommentStatus(int key, String name) {
        this.key = key;
        this.name = name;
    }
    public static CommentStatus getKey(Integer key){
        for(CommentStatus commentStatus : CommentStatus.values()){
            if(commentStatus.getKey() == key){
                return commentStatus;
            }
        }
        return null;
    }
    public int getKey(){
        return this.key;
    }
    public String getName(){
        return this.name;
    }
}

