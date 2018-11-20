package me.bestsamcn.blog.utils;

import me.bestsamcn.blog.models.Admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
import java.util.Date;
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

    /**
     * 校验字符串
     * @param str
     * @param lt
     * @param gt
     * @param name
     * @return
     */
    public static String assertString(String str, int lt, int gt, String name){
        if(str == null || str.trim().isEmpty()){
            return name+"不能为空";
        }
        if(str.length() < lt){
            return name+"长度不能小于"+lt;
        }
        if(str.length() > gt){
            return name+"长度不能大于"+gt;
        }
        return null;
    }
    /**
     * 向指定URL发送GET方法的请求
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 通过jsessionid获取用户
     * @param JSESSIONID
     * @return
     */
    public static Admin getAdmin(String JSESSIONID){
        HttpSession session = Session.get(JSESSIONID);
        if(session == null){
            return null;
        }
        Admin admin = (Admin) session.getAttribute(JSESSIONID);
        return admin;
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static Timestamp getTimestamp(){
        return new java.sql.Timestamp(new Date().getTime());
    }

}
