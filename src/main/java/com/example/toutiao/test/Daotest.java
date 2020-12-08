package com.example.toutiao.test;


import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.config.Emp;
import com.example.toutiao.controller.LoginController;
import com.example.toutiao.dao.CommentDao;
import com.example.toutiao.dao.NewsUserDao;
import com.example.toutiao.dao.TicketDao;
import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.Comment;
import com.example.toutiao.model.Ticket;
import com.example.toutiao.model.User;
import com.example.toutiao.model.group.NewsUser;
import com.example.toutiao.service.TicketService;
import com.example.toutiao.service.UserService;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.ibatis.binding.MapperProxy;

import java.util.*;
import java.util.stream.IntStream;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ToutiaoApplication.class)
public class Daotest {

    @Autowired
    UserDao userDao;

    @Autowired
    NewsUserDao newsUserDao;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    UserService userService;

    @Autowired
    LoginController loginController;

    @Autowired
    Emp emp;

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketDao ticketDao;

    @Autowired
    CommentDao commentDao;

    public enum  Color{
        red(1),white(2),black(3);

        private int i;
        Color(int i) {
        this.i=i;
        }
        int get(){
            return i;
        }
    }

    @Test
    public void main() {
//        Comment comment = new Comment();
//        comment.setType(0).setContent("测试得一条评论").setEntityId(1).setUserId(1);
//        commentDao.insertComment(comment);
    }


    public static void main(String[] args) {
        Color red = Color.red;
        System.out.println(red.getClass());
        System.out.println(red.i);
    }

}
