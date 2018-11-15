package com.dlut.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg)
    {
        System.out.println("正在发布程序!!!");
        applicationContext.publishEvent(new DemoEvent(this,"hello fys" + msg));
        System.out.println("发布程序已经完成!!!");
    }
}
