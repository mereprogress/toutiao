package com.example.toutiao.model;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Serializers;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;
import java.util.Collection;

//Serializable 普通模式只要
public class  User  implements Serializable {
    private int id;
    private String name;
    private String password;
    private String salt;
    private String headUrl;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public  User setId(int id) {
        this.id = id;
        return  this;
    }

    public String getName() {
        return name;
    }

    public  User setName(String name) {
        this.name = name;
        return  this;
    }

    public String getPassword() {
        return password;
    }

    public   User setPassword(String password) {
        this.password = password;
        return  this;
    }

    public String getSalt() {
        return salt;
    }

    public  User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public  User setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
        return this;
    }


}
