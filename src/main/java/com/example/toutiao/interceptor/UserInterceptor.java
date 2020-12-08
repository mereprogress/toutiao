package com.example.toutiao.interceptor;

import com.example.toutiao.model.HostUser;
import com.example.toutiao.model.User;
import com.example.toutiao.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Resource
    HostUser hostUser;
    @Autowired
    TicketService ticketService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        hostUser.setPath(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
        System.out.println(1);
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("ticket")){
                    String ticket = cookie.getValue();
                    User user = ticketService.getUser(ticket);
                    hostUser.setUser(user);
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
