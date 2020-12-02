package com.example.toutiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SecurityConfigSEVEN securityConfigSEVEN(){
        return new SecurityConfigSEVEN();
    }
    @Bean
    public MyMvcConfigurer myMvcConfigurer(){return new MyMvcConfigurer();} //Configurer 与原先一起作用


}
