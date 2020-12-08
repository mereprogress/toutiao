package com.example.toutiao.test;

import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToutiaoApplication.class)
public class RedisTest {
    @Resource
    private  RedisTemplate<String,String> redisTemplate;

    @Before
    public void pre(){
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);

        //改了默认序列化，pojo对象序列化也不能用了
    }

   @Test
   public void t() throws InterruptedException {
        //类似new File(), 先找好位置，不能知道存不存在
//       BoundValueOperations<String, String> key = redisTemplate.boundValueOps("key1");
//////       key.expire(30,TimeUnit.SECONDS);
//////       key.set("30");
//////       new Thread(()->{
//////           ValueOperations<String, String> ops = redisTemplate.opsForValue();
//////
//////           while (ops.get("key1")!=null){
//////               ops.increment("key1",-3L);
//////               System.out.println(ops.get("key1"));
//////           }
//////       }).start();


//       BoundHashOperations<String, Object, Object> hashKey = redisTemplate.boundHashOps("hashKey");
//       hashKey.put("name",new User().setName("张三").setPassword("123").setSalt("李四"));
//
//
//       HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
//       ops.put("hashkey1","first","opsForHash");


//       new Thread(()->{
//           BoundSetOperations<String, String> set = redisTemplate.boundSetOps("set");
//           char a='a';
//           while(true){
//               try {
//                   set.add(String.valueOf(a));
//                   a++;
//                   System.out.println(set.size());
//               }catch (Exception e){
//                   System.out.println(e.getMessage());
//               }
//
//           }
//       }).start();

       BoundSetOperations<String, String> set = redisTemplate.boundSetOps("set");
       Set<String> members = set.members();
        for (String str:members){
            System.out.println(str);
        }

   }

}
