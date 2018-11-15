package com.dlut.event;

import org.springframework.context.ApplicationEvent;

/**
 * 定义了一个事件,需要继承ApplicationEvent
 */
public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

}
