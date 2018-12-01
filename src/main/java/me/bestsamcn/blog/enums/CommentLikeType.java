package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/12/1 19:48
 */
public enum CommentLikeType {
    YES(10, "赞"),
    NOT(20, "踩");
    private int key;
    private String name;
    CommentLikeType(int key, String name) {
        this.key = key;
        this.name = name;
    }
    public static CommentLikeType getKey(Integer key){
        for(CommentLikeType commentLikeType : CommentLikeType.values()){
            if(commentLikeType.getKey() == key){
                return commentLikeType;
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
