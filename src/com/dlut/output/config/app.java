package com.dlut.output.config;

import com.dlut.output.OutputHelper;
import com.dlut.output.impl.CsvOutputGenerator;
import com.dlut.output.impl.JsonOutputGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

@Configuration
public class app {
    @Bean
//    @Autowired
    @Scope(value = "singleton")
    @Resource(name = "jsonOutputGenerator")
    public OutputHelper outputHelper(JsonOutputGenerator jsonOutputGenerator){
        return new OutputHelper(jsonOutputGenerator);
    }

    @Bean(name = "jsonOutputGenerator")
    public JsonOutputGenerator jsonOutputGenerator(){
        return new JsonOutputGenerator();
    }

    @Bean
    public CsvOutputGenerator csvOutputGenerator(){
        return new CsvOutputGenerator();
    }
}
