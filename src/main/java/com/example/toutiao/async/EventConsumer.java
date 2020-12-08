package com.example.toutiao.async;

import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.service.MessageService;
import com.example.toutiao.service.NewsUserService;
import com.example.toutiao.service.UserService;
import io.lettuce.core.ExperimentalLettuceCoroutinesApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventConsumer implements InitializingBean , ApplicationContextAware {

    Logger logger= LoggerFactory.getLogger(ToutiaoApplication.class);

    ApplicationContext applicationContext;

    Map<EventType, List<Handler>> map=new HashMap<>();
    //hashMap 初始容量16 但是只能存 0.75*16个元素 扩容修改为2的倍数
    //即开始 2的四次方  1 << 4 一左移四次
    //当需要扩容时 1<<5 那就是32了 ，如果知道

    @Resource
    RedisTemplate<String,EventModel> redisTemplate;

    //下面的service可以异步调用 ，这样就可以不在controller使用service
    @Resource
    NewsUserService newsUserService; //这个可以代理在controller使用

    @Resource
    UserService userService; // 这个不能放在这里 ，要放在对应的处理器

    @Resource
    MessageService messageService;

    //bean的初始化方法 对标 销毁
    // 中三种方式出现
    @Override
    public void afterPropertiesSet() throws Exception {
        //先获得所用事件处理器
            //1先获取容器 可以通过aware方法获取，bean初始化回调
        Map<String, Handler> map = applicationContext.getBeansOfType(Handler.class);
        for(Map.Entry<String,Handler> entry:map.entrySet()){
            //分类
            //存起来
            EventType type = entry.getValue().getType();
            if(this.map.containsKey(type)){
                this.map.get(type).add(entry.getValue());
            }else{
                ArrayList<Handler> handlers = new ArrayList<>();
                handlers.add(entry.getValue());
                this.map.put(type,handlers);
            }
        }

        //按类型分配
        //再从redis获取事件
        //然后进行处理

        while(true){
            BoundListOperations<String, EventModel> list = redisTemplate.boundListOps(MessageProducer.EVENT);
             EventModel eventModel  = list.leftPop();
             //获取信息来对应对应的service
            try {
                List<Handler> handlers = this.map.get(eventModel.getType());
                for(Handler handler:handlers){
                    handler.handler(eventModel);
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }



        }


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
