package com.example.toutiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {



    @Bean
    public SecurityConfigSEVEN securityConfigSEVEN(){
        System.out.println("我执行了");
        return new SecurityConfigSEVEN();
    }
    @Bean
    public MyMvcConfigurer myMvcConfigurer(){return new MyMvcConfigurer();} //Configurer 与原先一起作用

    @Bean
    public Emp emp(){
        return  new Emp();
    }

}
