package com.example.toutiao.model;

import org.springframework.stereotype.Component;

//当前用户
@Component
public class HostUser {
    //如果使用成员变量，就是，创建的时候加载
    //如果使用spring 注入的方式使用，那么就只有一个实例
    //其他境况有多个，
    //所以最后static 保证单例
    private static ThreadLocal<User> userThreadLocal=new ThreadLocal<>();
    private static ThreadLocal<String> pathThreadLocal=new ThreadLocal<>();

    //下面的方法需不需要stat
    //这种是依赖倒置
     public void setUser(User user){
        if(userThreadLocal.get()!=null){return;}
        userThreadLocal.set(user);
    }
    public User getUser(){
        return userThreadLocal.get();
    }
    public void removeUser(){
        userThreadLocal.remove();
    }

    public void setPath(String path){
         if(pathThreadLocal.get()!=null){return;}
         pathThreadLocal.set(path);
    }
    public String getPath(){return pathThreadLocal.get();}

}
