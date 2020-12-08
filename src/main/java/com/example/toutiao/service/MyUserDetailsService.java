package com.example.toutiao.service;

import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.getUserByName(username);
        System.out.println("MyUserDetailsService");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUser(user);
    }
}
