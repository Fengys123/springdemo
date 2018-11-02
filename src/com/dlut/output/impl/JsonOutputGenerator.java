package com.dlut.output.impl;

import com.dlut.output.IOutputGenerator;
import org.springframework.stereotype.Component;

@Component
public class JsonOutputGenerator implements IOutputGenerator {
    @Override
    public void generateOutput() {
        System.out.println("Json Output Generator");
//        throw new Exception();
        //int i = 1/0;
    }
}
