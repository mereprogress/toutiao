package com.example.toutiao.async;

import com.example.toutiao.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class LikeHandler implements Handler{

    @Autowired
    NewsUserService newsUserService;



    //重写 权限大 返回 异常 小
    @Override
    public void handler(EventModel eventModel) {
        //先获取eventModel信息
        //通过likeService处理
        try {
            newsUserService.updateLikeCount(eventModel.getEntityId(),eventModel.getUserId());
        }catch (Exception e){
            //喜欢失败
        }

    }

    @Override
    public EventType getType() {
        return EventType.like;
    }
}
