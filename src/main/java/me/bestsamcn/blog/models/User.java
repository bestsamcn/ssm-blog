package me.bestsamcn.blog.models;

import org.springframework.stereotype.Repository;

/**
 * @Author: Sam
 * @Date: 2018/10/26 0:35
 */
@Repository("user")
public class User {
    private String id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

