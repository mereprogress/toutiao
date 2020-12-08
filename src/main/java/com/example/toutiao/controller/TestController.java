package com.example.toutiao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.toutiao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class TestController {




    @PostMapping("/Test1")
    @ResponseBody
    Object asad(){

        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","names");
        map.put("2","namess");
        map.put("1",1);
        map.put("2",null);
        map.put("3",true);
        Object o = JSON.toJSON(map);

        return o;
    }

    @PostMapping("/Test3")
    @ResponseBody
    Object asadsss(){


        ArrayList<Object> objects = new ArrayList<Object>();
        objects.add(1);
        objects.add(true);
        objects.add("米好");
        objects.add(JSON.toJSONString(new Date(),SerializerFeature.WriteDateUseDateFormat));
        User user = new User();
        user.setName("张三");
        user.setPassword("123");
        user.setSalt("李四");
        objects.add(user);
        Object o = JSON.toJSON(objects);
        Object s = JSON.toJSON(objects);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("obj",s);
        return JSON.toJSONString(objectObjectHashMap);
    }


}
