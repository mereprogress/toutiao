package com.example.toutiao.async;

import java.util.List;

public interface Handler {
    //事件接口，这个这个接口可以获取所有事件处理器



    //重写 权限大 返回 异常 小
    void handler(EventModel eventModel);

    //获取支持的事件类型
    EventType getType();
}
