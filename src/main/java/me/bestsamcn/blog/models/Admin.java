package me.bestsamcn.blog.models;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * @Author: Sam
 * @Date: 2018/10/26 0:35
 */
@Repository
public class Admin {
    private String id;
    private String account;
    private String password;
    private String avatar;
    private String email;
    private String mobile;
    private Timestamp createTime;
    private String createIp;
    private Timestamp lastUpdateTime;
    private Timestamp lastLoginTime;
    private String userType;
    private Timestamp setAdminTime;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setAccount(String account){
        this.account = account;
    }
    public String getAccount(){
        return this.account;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    public void setCreateIp(String createIp){
        this.createIp = createIp;
    }
    public String getCreateIp(){
        return this.createIp;
    }
    public void setLastUpateTime(Timestamp lastUpdateTime){
        this.lastUpdateTime = lastUpdateTime;
    }
    public Timestamp getLastUpdateTime(){
        return this.lastUpdateTime;
    }
    public void setLastLoginTime(Timestamp lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    public Timestamp getLastLoginTime(){
        return this.lastLoginTime;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getUserType(){
        return this.userType;
    }
    public void setSetAdminTime(Timestamp setAdminTime){
        this.setAdminTime = setAdminTime;
    }
    public Timestamp getSetAdminTime(){
        return this.setAdminTime;
    }
}

