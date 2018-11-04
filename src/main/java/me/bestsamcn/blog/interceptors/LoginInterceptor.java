package me.bestsamcn.blog.interceptors;

import me.bestsamcn.blog.annotations.LoginRequired;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.utils.Session;
import me.bestsamcn.blog.utils.Tools;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.rmi.runtime.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Sam
 * @Date: 2018/11/4 18:11
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){

            LoginRequired loginRequired =
                    ((HandlerMethod) handler).getBeanType().getAnnotation(LoginRequired.class);

            if(loginRequired == null){
                loginRequired = ((HandlerMethod) handler).getMethodAnnotation(LoginRequired.class);
            }
            if(loginRequired == null){
                return true;
            }
            Cookie cookie = Tools.getCookie(request, "JSESSIONID");
            if(cookie == null){
                response.setStatus(401);
                return false;
            }
            String JSESSIONID = cookie.getValue();
            if(JSESSIONID == null){
                response.setStatus(401);
                return false;
            }
            HttpSession session = Session.get(JSESSIONID);
            if(session == null){
                response.setStatus(401);
                return false;
            }
            if(session.getAttribute(JSESSIONID) == null){
                response.setStatus(401);
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }
}
