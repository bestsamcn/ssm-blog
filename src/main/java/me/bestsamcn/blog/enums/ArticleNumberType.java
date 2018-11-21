package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/11/21 22:40
 */
public enum ArticleNumberType {
    READ("readNum", "阅读"),
    LIKE("likeNum","点赞" ),
    COMMENT("commentNum", "评论");
    private String key;
    private String name;
    ArticleNumberType(String key, String name) {
        this.key = key;
        this.name = name;
    }
    public static ArticleNumberType getKey(Integer key){
        for(ArticleNumberType articleType : ArticleNumberType.values()){
            if(articleType.getKey().equals(key)){
                return articleType;
            }
        }
        return null;
    }
    public String getKey(){
        return this.key;
    }
    public String getName(){
        return this.name;
    }
}
