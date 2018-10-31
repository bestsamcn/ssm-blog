package me.bestsamcn.blog.utils;

import java.security.MessageDigest;
import java.util.UUID;
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
}
