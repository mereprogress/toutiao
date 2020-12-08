package com.example.toutiao.component;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

//类似工具类，只用方法，没有实体，为了更加简洁，都是static方法
public class MyJSON {
    public static JSONObject getJSON(int code){
        JSONObject object = new JSONObject();
        object.put("code",code);
        return object;
    }
    //用于直接返回，并填写登陆状态
    public static   JSONObject getJSON(int code,String msg){
        JSONObject object = new JSONObject();
        object.put("code",code);
        object.put("msg",msg);
        return object;
    }

    public static JSONObject getJSON(int code, Map<String,Object> map){
        JSONObject object = new JSONObject();
        object.put("code",code);
        for (Map.Entry<String,Object> objectEntry:map.entrySet()){
            object.put(objectEntry.getKey(),objectEntry.getValue());
        }
        return object;

    }
}
