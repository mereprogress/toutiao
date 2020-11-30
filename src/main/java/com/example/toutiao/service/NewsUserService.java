package com.example.toutiao.service;

import com.example.toutiao.dao.NewsUserDao;
import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.group.NewsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsUserService {

    @Resource
    NewsUserDao newsUserDao;

    @Autowired(required = false)
    @Qualifier(value = "userDao")
    UserDao userDao;


    public List<NewsUser> getPath(int offset, int length) {
        return newsUserDao.getPart(offset,length);
    }

    public Integer getCount() {
    return newsUserDao.getCount();
    }
}
