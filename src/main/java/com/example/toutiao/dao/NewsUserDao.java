package com.example.toutiao.dao;

import com.example.toutiao.model.group.NewsUser;

import java.util.List;

public interface NewsUserDao {

    List<NewsUser> getPart(int offset,int length);
}
