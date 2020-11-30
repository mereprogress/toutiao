package com.example.toutiao.controller;

import com.example.toutiao.model.group.NewsUser;
import com.example.toutiao.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
    String main(Map<String,Object> map,@PathVariable("page") int page){
        List<NewsUser> vos=newsUserService.getPath((page-1)*10,page*10);
        map.put("vos",vos);
        if(count==null){
            count=newsUserService.getCount();
        }
        map.put("count",count);
        return "index";
    }
}
