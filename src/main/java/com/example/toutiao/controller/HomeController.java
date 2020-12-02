package com.example.toutiao.controller;

import com.example.toutiao.info.NewsUsers;
import com.example.toutiao.model.group.NewsUser;
import com.example.toutiao.service.NewsUserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Dates;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.Format;
import java.util.*;

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
//        List<NewsUser> vos=newsUserService.getPath(0,100);
        List<NewsUsers> voss=new ArrayList<>();
        pass(vos,voss);
//        for (NewsUsers newsUsers:voss){
//            System.out.println(newsUsers.getNewsUserList());
//        }

        map.put("vos",vos);
        map.put("voss",voss);
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
//        System.out.println("总页数"+num);
//        System.out.println("当前页数"+page);
        return "index";
    }

    @GetMapping("/indexCount/{count}")
    void indexCount(@PathVariable("count") int pageCount, HttpServletRequest request, HttpServletResponse response) throws IOException {
       //改名显示数量，放在会话，用户作用域中
        HttpSession session = request.getSession();
        session.setAttribute("pageCount",pageCount);

        response.sendRedirect("http://localhost:8080/index/1");
    }

    void pass(List<NewsUser> vos,List<NewsUsers> voss){
        for(NewsUser vo:vos){
            Date createDate = vo.getNews().getCreateDate();
//            System.out.println(voss.size());
            int i=0;
            if(voss.size()==0){
                //开始voss 为空，添加一个元素
                NewsUsers newsUsers = new NewsUsers();
                newsUsers.setDate(createDate);
                List<NewsUser> newsUsers1 = new ArrayList<>();
                newsUsers1.add(vo);
                newsUsers.setNewsUserList(newsUsers1);
                voss.add(newsUsers);
//                System.out.println("首次创建了集合");
                continue;
            }
            //进入以后的循环
            for(NewsUsers newsUsers:voss){
                //判定voss 有没有同一天的元素

                if(createDate.equals(newsUsers.getDate())){
                    //有 就 插入
//                    System.out.println("集合插入了数据");
                    newsUsers.getNewsUserList().add(vo);
                    break;
                }
                i++;
                //传递一个信号表示，循环完没有找到合适合适集合
            }
            if(i!=voss.size()){continue;}
            //如果上面的循环判定完，没有相同一天的对象的集合
            //创建新的集合，插入voss
            NewsUsers newsUsers = new NewsUsers();
            newsUsers.setDate(createDate);
            List<NewsUser> newsUsers1 = new ArrayList<NewsUser>();
            newsUsers1.add(vo);
            newsUsers.setNewsUserList(newsUsers1);
//            System.out.println("创建了集合");
            voss.add(newsUsers);
        }
    }
}
