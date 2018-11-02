package com.dlut.Config;

import com.dlut.output.OutputHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OutputConfig
{
    @Bean(name="outputHelper")
    public OutputHelper GeneratOutputHelper(){
        return new OutputHelper();
    }
}
