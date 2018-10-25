package com.dlut.output.impl;

import com.dlut.output.IOutputGenerator;
import org.springframework.stereotype.Component;

@Component
public class CsvOutputGenerator implements IOutputGenerator {

    @Override
    public void generateOutput() {
        System.out.println("Csv Output Generator");
    }
}
