package me.bestsamcn.blog.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: Sam
 * @Date: 2018/11/4 15:55
 */
public class Session {
    private static HashMap<String,Object>sessions = new HashMap();

    /**
     * 添加session
     * @param session
     */
    public static synchronized void add(HttpSession session){
        sessions.put(session.getId(), session);
    }

    /**
     * 删除sesion
     * @param id
     */
    public static synchronized void delete(String id){
        sessions.remove(id);
    }

    /**
     * 获取session
     * @param id
     * @return
     */
    public static synchronized HttpSession get(String id){
        return (HttpSession) sessions.get(id);
    }

}
