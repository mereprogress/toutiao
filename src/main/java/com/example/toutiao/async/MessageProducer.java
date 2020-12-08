package com.example.toutiao.async;

import com.example.toutiao.ToutiaoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageProducer {
//发出一个事件给redis

    Logger logger=LoggerFactory.getLogger(ToutiaoApplication.class);

    @Resource
    RedisTemplate<String,EventModel> redisTemplate;

    static String EVENT="eventKey";

    void send(EventModel eventModel){
        BoundListOperations<String, EventModel> list = redisTemplate.boundListOps(EVENT);
        try {
            list.leftPush(eventModel);
        }catch (Exception e){
            logger.error("不能发出消息");
        }

    }

}
