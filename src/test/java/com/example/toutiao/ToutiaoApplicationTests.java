package com.example.toutiao;

import com.example.toutiao.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToutiaoApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao);
    }

}
