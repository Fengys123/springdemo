package com.dlut.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class afterOutputMethod implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("再返回结果之后执行的函数");
    }
}
