package com.example.toutiao.service;

import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserDao userDao;


    public User exist(String username,String password) {
        return userDao.getByNameAndPassword(username, password);
    }


}
