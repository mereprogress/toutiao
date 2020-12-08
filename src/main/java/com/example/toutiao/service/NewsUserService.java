package com.example.toutiao.service;

import com.example.toutiao.dao.NewsUserDao;
import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.News;
import com.example.toutiao.model.group.NewsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    public List<NewsUser> getPath(int offset, int length) {
        return newsUserDao.getPart(offset,length);
    }

    public Integer getCount() {
    return newsUserDao.getCount();
    }

    public void updateLikeCount(int newsId, int userId) throws Exception {
        BoundSetOperations<String, Object> set = redisTemplate.boundSetOps("like:" + newsId);
        Boolean member = set.isMember(newsId);
        if(member){
            throw new Exception("用户已点赞");
        }
       set.add(newsId);
       newsUserDao.updateLike(newsId,set.size());
    }

    public void updateDisLikeCount(int newsId, int userId) throws Exception {
        BoundSetOperations<String, Object> set = redisTemplate.boundSetOps("like:" + newsId);
        Boolean member = set.isMember(newsId);
        if(!member){
            throw new Exception("用户未点赞");
        }
        set.remove(userId);
        newsUserDao.updateLike(newsId,set.size());
    }
}
