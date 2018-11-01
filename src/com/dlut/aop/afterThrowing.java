package com.dlut.aop;

import org.springframework.aop.ThrowsAdvice;

public class afterThrowing implements ThrowsAdvice {
    public void afterThrowing(Exception e) throws  Throwable{
        System.out.println("After Throw Exception 执行的方法:");
    }

}
