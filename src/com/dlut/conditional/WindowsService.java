package com.dlut.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Conditional(WindowsCondition.class)
public class WindowsService
{
    private int i;

    @PostConstruct
    public void init()
    {
        System.out.println("Windows Init!!!");
    }

    @PreDestroy
    public void destory()
    {
        System.out.println("Windows Destory!!!");
    }
}
