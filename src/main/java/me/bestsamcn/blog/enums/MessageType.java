package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/11/10 23:41
 */
public enum MessageType {
    ALL(10, "全部"),
    YES(20, "已读"),
    NOT(30, "未读");

    private int key;
    private String name;
    MessageType(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public static MessageType getEnum(Integer key){
        for(MessageType messageType : MessageType.values()){
            if(messageType.getKey() == key){
                return messageType;
            }
        }
        throw new IllegalArgumentException("No element matches " + key);
    }

    public int getKey(){
        return this.key;
    }

    public Object getName(){
        return this.name;
    }
}
