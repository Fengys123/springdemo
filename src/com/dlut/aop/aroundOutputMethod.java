package com.dlut.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class aroundOutputMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("之前执行");
        try{
            Object result = methodInvocation.proceed();

            // same with AfterReturningAdvice
            System.out.println("之后执行");
            return result;
        } catch (Exception e){
            System.out.println("抛出异常后报错");
        }
        return null;

    }
}
