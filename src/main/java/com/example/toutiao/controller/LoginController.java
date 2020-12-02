package com.example.toutiao.controller;

import com.example.toutiao.model.User;
import com.example.toutiao.model.group.NewsUser;
import com.example.toutiao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Resource
    UserService userService;

    @PostMapping("/user")
    @ResponseBody
    String userLogin(@RequestParam(value = "username",defaultValue ="") String username, @RequestParam(value ="password",defaultValue = "") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(username.equals("")){return "填写用户名";}
        if(password.equals("")){return "填写密码";}

        User user = new User();
        user.setPassword(username);
        user.setPassword(password);
       user= userService.login(user);
        if(user==null){
            return "用户名或者密码错误";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        response.sendRedirect("/index/1");
        return "成功";
    }
}
