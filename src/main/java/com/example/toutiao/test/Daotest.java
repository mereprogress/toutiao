package com.example.toutiao.test;


import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToutiaoApplication.class)
public class Daotest {

    @Autowired
    UserDao userDao;

    @Test
    public void main() {
        User user=new User();
        user.setName("user12");

        System.out.println(userDao.get(user));
    }

}
