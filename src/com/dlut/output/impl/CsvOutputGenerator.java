package com.dlut.output.impl;

import com.dlut.output.IOutputGenerator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CsvOutputGenerator implements IOutputGenerator {

    @Override
    public void generateOutput() {
        System.out.println("Csv Output Generator");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("jsr250-init-method!!!");
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("jsr250-destroy-method!!!");
    }
}
