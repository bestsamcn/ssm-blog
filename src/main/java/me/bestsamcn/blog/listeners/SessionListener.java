package me.bestsamcn.blog.listeners;

import me.bestsamcn.blog.utils.Session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: Sam
 * @Date: 2018/11/4 15:54
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        Session.add(httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        Session.delete(httpSessionEvent.getSession().getId());
    }
}
