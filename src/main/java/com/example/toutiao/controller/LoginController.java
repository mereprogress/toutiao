package com.example.toutiao.controller;

import com.example.toutiao.component.MyJSON;
import com.example.toutiao.model.HostUser;
import com.example.toutiao.model.Ticket;
import com.example.toutiao.model.User;
import com.example.toutiao.model.group.NewsUser;
import com.example.toutiao.service.TicketService;
import com.example.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    UserService userService;

    @Resource
    HostUser hostUser;

    @Autowired
    TicketService ticketService;

    @PostMapping("/user")
    @ResponseBody
    Object userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(username);
        if(username==null||username.equals("")){ return MyJSON.getJSON(0,"用户名不为空");}
        if(password==null||password.equals("")){return MyJSON.getJSON(0,"密码不能为空");}
        User user =userService.exist(username,password); //通过用户名 密码，查找获取
        if(user==null){return MyJSON.getJSON(0,"密码或者或者用户名不正确");}
        hostUser.setUser(user);
        Ticket ticket= ticketService.updateCount(user.getId());
        Cookie cookie = new Cookie("ticket",ticket.getTicket());
        response.addCookie(cookie);
        return MyJSON.getJSON(1,"成功登陆");


    }

    @RequestMapping("/login")
    public String login(Model model)
    {
        return "login";
    }
}
