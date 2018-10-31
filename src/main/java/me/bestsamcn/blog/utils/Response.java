package me.bestsamcn.blog.utils;

import org.springframework.stereotype.Component;

/**
 * @Author: Sam
 * @Date: 2018/10/31 21:18
 */
public class Response<T> {
    private int retCode=0;
    private String msg;
    private T data;

    /**
     * 请求成功
     * @return
     */
    public static Response success(String msg){
        return new Response().setMsg(msg);
    }

    /**
     * 请求成功
     * @return
     */
    public static Response success(){
        return new Response().setMsg("请求成功");
    }

    /**
     * 结果集封装
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response build(T data){
        return new Response().setData(data);
    }

    /**
     * 设置结果编码便返回实例
     * @param retCode
     * @return
     */
    public Response setRetCode(int retCode){
        this.retCode = retCode;
        return this;
    }

    /**
     * 设置信息便返回实例
     * @param msg
     * @return
     */
    public Response setMsg(String msg){
        this.msg = msg;
        return this;
    }

    /**
     * 设置结果数据
     * @param data
     * @return
     */
    public Response setData(T data){
        this.data = data;
        return this;
    }

    /**
     * 失败
     * @param msg
     * @return
     */
    public static Response error(String msg){
        Response res = new Response();
        res.setMsg(msg);
        res.setRetCode(-1);
        return res;
    }

    /**
     * 失败
     * @return
     */
    public static Response error(){
        Response res = new Response();
        res.setMsg("异常");
        res.setRetCode(-1);
        return res;
    }
}
