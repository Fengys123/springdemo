package com.dlut.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Conditional(LinuxCondition.class)
public class linuxService
{
    private int i;

    @PostConstruct
    public void init()
    {
        System.out.println("Linux Init!!!");
    }

    @PreDestroy
    public void destory()
    {
        System.out.println("Linux Destory!!!");
    }
}
