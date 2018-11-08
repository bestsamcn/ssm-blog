package me.bestsamcn.blog.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Sam
 * @Date: 2018/10/31 21:40
 */
public class Tools {

    /**
     * 获取id
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");
        return id;
    }

    /**
     * 检验字符串是否是数字
     *
     * @param num
     * @return
     */
    public static boolean isNumber(String num) {
        if (num == null) return false;
        num = num.trim();
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(num).matches();
    }

    /**
     * 密码加密
     *
     * @param s
     * @param method
     * @return
     */
    public static String generatePassword(String s, String method) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            //如果输入“SHA”，就是实现SHA加密。
            MessageDigest mdTemp = MessageDigest.getInstance(method);
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 密码加密
     *
     * @return
     */
    public static String generatePassword(String password) {
        String method = "SHA1";
        return Tools.generatePassword(password, method);
    }

    /**
     * 正则判断
     * @param reg
     * @param str
     * @return
     */
    public static boolean isMatch(String reg, String str){
        if(reg == null || reg.isEmpty()) return false;
        if(str == null || str.isEmpty()) return false;
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 设置cookie
     * @param name
     * @param value
     * @param days
     * @param res
     */
    public static void setCookie(String name, String value, int days, boolean isHttpOnly, HttpServletResponse res){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(days * 3600);
        cookie.setHttpOnly(isHttpOnly);
        res.addCookie(cookie);
    }

    /**
     * 删除cookie
     * @param name
     * @param req
     * @param res
     */
    public static void delCookie(String name, HttpServletRequest req, HttpServletResponse res){
        Cookie[] cookies = req.getCookies();
        if(cookies == null) return;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(name)){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                res.addCookie(cookie);
                break;
            }
        }
    }

    /**
     * 通过cookie名称获取cookie
     * @param req
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest req, String name){
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 获取指定配置固定属性
     * @param propName
     * @return
     * @throws IOException
     */
    public static String getConfigProperty(String propName){
        Properties props = new Properties();
        InputStream in = Tools.class.getClassLoader().getResourceAsStream("config.properties");
        try{
            props.load(in);
            return props.getProperty(propName);
        }catch(Exception e){
            return null;
        }
    }
}
