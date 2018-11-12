package me.bestsamcn.blog.models;

import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2018/11/13 1:36
 */
public class IpInfoVO {
    private String code;
    private Map<String, String> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
