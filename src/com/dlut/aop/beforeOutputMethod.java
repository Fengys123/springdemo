package com.dlut.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class beforeOutputMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("在指定方法前执行的方法");
    }
}
