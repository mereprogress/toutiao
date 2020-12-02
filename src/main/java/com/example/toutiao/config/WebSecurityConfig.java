package com.example.toutiao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/styles/**","/scripts/**").permitAll() //指定那些URL不要被保护
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll() //登录任意访问
                .and()
                .rememberMe() //rememberMe
                .and() //注销行为任意访问
                .logout()
                .permitAll()
                .and()
                .csrf() ;//关闭csrf 不然不支持post
//                .authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                //用户名密码和角色
                .withUser("jyq").password("123456").roles("USER");
    }


}
