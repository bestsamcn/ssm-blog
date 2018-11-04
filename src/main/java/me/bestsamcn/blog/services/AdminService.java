package me.bestsamcn.blog.services;

import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.utils.Response;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Sam
 * @Date: 2018/10/30 20:56
 */
public interface AdminService {

    /**
     * 通过id获取
     * @param id
     * @return
     */
    public Admin getById(String id);

    /**
     * 新增
     * @param account
     * @param password
     * @return
     */
    public Response add(String account, String password);

    /**
     * 删除
     * @param id
     * @return
     */
    public Response delete(String id);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Response getList(int pageIndex, int pageSize);

    /**
     * 修改
     * @param id
     * @param account
     * @param email
     * @param mobile
     * @param avatar
     * @return
     */
    public Response edit(String id, String account, String email, String mobile, String avatar);

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    public Response login(String account, String password, String JSESSIONID, HttpSession session, HttpServletResponse resp);

    /**
     * 修改密码
     * @param id
     * @param password
     * @param rePassword
     * @return
     */
    public Response editPassword(String id, String password, String rePassword);

    /**
     * 保存用户状态
     * @param admin
     * @param session
     * @param res
     */
    public void setLoginState(Admin admin, HttpSession session, HttpServletResponse res);

    /**
     * 通过cookie获取当前用户
     * @param JSESSIONID
     */
    public Response getInfo(String JSESSIONID);

}
