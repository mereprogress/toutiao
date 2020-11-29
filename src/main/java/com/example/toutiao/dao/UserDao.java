package com.example.toutiao.dao;

import com.example.toutiao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {
    User get(User user);
    void Insert(User user);
}
