package com.example.toutiao.controller;

import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.component.MyJSON;
import com.example.toutiao.model.HostUser;
import com.example.toutiao.service.NewsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Controller
public class likeController {

    Logger logger= LoggerFactory.getLogger(ToutiaoApplication.class);

    @Autowired
    HostUser hostUser;

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    NewsUserService newsUserService;

    @GetMapping("/like")
    Object like(@RequestBody int newsId){
        try {
            if(hostUser.getUser()==null){
                throw new Exception("用户没登陆");
            }
            int userId=hostUser.getUser().getId();
           newsUserService.updateLikeCount(newsId,userId);


        } catch (Exception e) {
            logger.error(e.getMessage());
            return MyJSON.getJSON(0,e.getMessage().toString());
        }


        return null;
    }
}
