package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/11/13 19:53
 */
public enum ArticleType {
    ALL(0, "全部"),
    PUBLIC(10, "公开"),
    PRIVATE(20, "私有");
    private int key;
    private String name;
    ArticleType(int key, String name) {
        this.key = key;
        this.name = name;
    }
    public static ArticleType getKey(Integer key){
        for(ArticleType articleType : ArticleType.values()){
            if(articleType.getKey() == key){
                return articleType;
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
