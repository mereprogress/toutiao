package com.example.toutiao.test;


import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.dao.NewsUserDao;
import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.User;
import com.example.toutiao.model.group.NewsUser;
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToutiaoApplication.class)
public class Daotest {

    @Autowired
    UserDao userDao;

    @Autowired
    NewsUserDao newsUserDao;

    @Autowired
    SqlSessionFactory sqlSessionFactory;


    @Test
    public void main() {
//        System.out.println(newsUserDao.getPart(0,1));
        User user=new User();
        user.setName("admin");
        user.setPassword("admin");
        user.setSalt("张三");
        user.setHeadUrl("/image/admin.jsp");
        userDao.insert(user);
        System.out.println(user);
    }

}
