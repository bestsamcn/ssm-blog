package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/11/29 23:31
 */
public enum PictureType {
    ALL(0, "全部"),
    POSTER(10, "海报"),
    IMAGE(20, "图片");
    private int key;
    private String name;
    PictureType(int key, String name) {
        this.key = key;
        this.name = name;
    }
    public static PictureType getKey(Integer key){
        for(PictureType pictureType : PictureType.values()){
            if(pictureType.getKey() == key){
                return pictureType;
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
