package com.dlut.Aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectj {
    /*@Before("execution(*com.dlut.output.impl)")
    public void beforeGenerateOutput(){
        System.out.println("在输出前执行的方法");
    }*/

    @Pointcut("@annotation(com.dlut.Aspectj.annotation.Action)")
    public void annoationPointCut(){};

    @After("annoationPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("在方法之后执行");
    }

    @Before("execution(* com.dlut.output.OutputHelper.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("在方法之前执行");
    }
}
