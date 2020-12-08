package com.example.toutiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.toutiao.component.MyJSON;
import com.example.toutiao.model.User;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class ImageController {
    @PostMapping("/image/upload/{id}")
    @ResponseBody
    Object upload(Map<String,MultipartFile> files, HttpServletRequest request) throws IOException {
        JSONObject jsonObject = new JSONObject();
        System.out.println(files);
        try {


        for(Map.Entry<String,MultipartFile> entry:files.entrySet()) {
                MultipartFile file=entry.getValue();
            jsonObject.put("status", MyJSON.getJSON(1, "图片上传成功"));
            jsonObject.put("name", file.getName());
            String type = ".jpg";
            try {
                System.out.println(file.getOriginalFilename());
                System.out.println(file.getOriginalFilename().split("\\.").length);
                type = "." + file.getOriginalFilename().split("\\.")[1];
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            jsonObject.put("size", file.getSize());
            try {
                String url = ResourceUtils.getURL("classpath:static/image/test").getPath();
                File file1 = new File(url);
                System.out.println(file1.exists());
                System.out.println(file1.isDirectory());
                System.out.println(file1.toString());
                File file2 = new File(file1, UUID.randomUUID().toString() + type);
                System.out.println(file2.toString());
                file.transferTo(file2);


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(ResourceUtils.getURL("classpath:static/image").getPath());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        }catch (Exception e){
                    System.out.println(e.getMessage());
        }
        return jsonObject;
    }


    @PostMapping("/json")
    @ResponseBody
    Object sss(@RequestBody User user){
        JSONObject object=new JSONObject();
        System.out.println(user);

        return  MyJSON.getJSON(1,"hello");
    }
}
