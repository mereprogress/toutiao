package com.example.toutiao.controller;

import com.example.toutiao.model.group.NewsUser;
import com.example.toutiao.service.NewsUserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class HomeController {

    @Resource
    NewsUserService newsUserService;
    private Integer count;


    @GetMapping(value = {"/","/index"})
    String main(Map<String,Object> map , HttpServletResponse response){
//        List<NewsUser> vos=newsUserService.getPath(0,10);
//        map.put("vos",vos);
//        if(count==null){
//            count=newsUserService.getCount();
//        }
//        map.put("count",count);

        return "redirect:index/1";
    }

    @GetMapping(value = "/index/{page}")
    String main(Map<String,Object> map,@PathVariable("page") int page,HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer pageCount = (Integer) session.getAttribute("pageCount");
        if(pageCount==null){
            pageCount=10;
        }
        //从会话总获取，显示条数，没有默认为10

        List<NewsUser> vos=newsUserService.getPath((page-1)*pageCount,pageCount);
        map.put("vos",vos);
        if(count==null){
            count=newsUserService.getCount();
        }
        //从全局中获取总的条数，没有进行查询你

        //总页数 ，每次请求，都要更新，
        Integer  num=count/pageCount +1;

        map.put("page",(double)page);
        map.put("count",count);
        map.put("num",num);
        map.put("pageCount",pageCount);
        System.out.println("总页数"+num);
        System.out.println("当前页数"+page);
        return "index";
    }

    @GetMapping("/indexCount/{count}")
    void indexCount(@PathVariable("count") int pageCount, HttpServletRequest request, HttpServletResponse response) throws IOException {
       //改名显示数量，放在会话，用户作用域中
        HttpSession session = request.getSession();
        session.setAttribute("pageCount",pageCount);

        response.sendRedirect("http://localhost:8080/index/1");
    }
}
