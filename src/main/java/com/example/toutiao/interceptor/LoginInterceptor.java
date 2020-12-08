package com.example.toutiao.interceptor;

import com.example.toutiao.model.HostUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies==null){ response.sendRedirect("/login");return false;}
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("ticket")){
              return true;
            }
        }
        response.sendRedirect("/login");
        return false;
    }
}
