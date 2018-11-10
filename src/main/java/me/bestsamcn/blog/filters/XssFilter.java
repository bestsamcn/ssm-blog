package me.bestsamcn.blog.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Sam
 * @Date: 2018/11/10 22:15
 */
@WebFilter(urlPatterns = "*")
public class XssFilter extends BaseFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getMethod();
        if( method.toLowerCase() == "get" ){
            filterChain.doFilter(req, resp);
            return;
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "application/json");
        HttpRequestFilter httpRequestFilter = new HttpRequestFilter(req);
        filterChain.doFilter(httpRequestFilter, resp);
    }
}
