package com.example.toutiao;

import com.example.toutiao.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class ToutiaoApplication {


    public static void main(String[] args) {
        SpringApplication.run(ToutiaoApplication.class, args);
    }

}
