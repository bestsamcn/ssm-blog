package me.bestsamcn.blog.enums;

/**
 * @Author: Sam
 * @Date: 2018/11/11 20:33
 */

public enum LogitType {
    ALL(10, "全部"),
    YES(20, "控制日志"),
    NOT(30, "服务日志");

    private int key;
    private String name;
    LogitType(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public static MessageType getEnum(Integer key){
        for(MessageType messageType : MessageType.values()){
            if(messageType.getKey() == key){
                return messageType;
            }
        }
        return null;
    }

    public int getKey(){
        return this.key;
    }

    public Object getName(){
        return this.name;
    }
}

