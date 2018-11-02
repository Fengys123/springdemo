package com.dlut.Config;

import com.dlut.output.IOutputGenerator;
import com.dlut.output.OutputHelper;
import com.dlut.output.impl.CsvOutputGenerator;
import com.dlut.output.impl.JsonOutputGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.dlut")
public class app {
    @Bean(name = "outputHelper1")
    @Scope(value = "singleton")
    @Resource(name = "csvOutputGenerator")
    public OutputHelper outputHelper1(IOutputGenerator csvOutputGenerator){
        return new OutputHelper((CsvOutputGenerator)csvOutputGenerator);
    }

    @Bean(name = "outputHelper")
    @Scope(value = "singleton")
    public OutputHelper outputHelper(){
        OutputHelper outputHelper =  new OutputHelper();
        outputHelper.setOutputGenerator(jsonOutputGenerator());
        return outputHelper;
    }

    @Bean(name = "jsonOutputGenerator")
    public JsonOutputGenerator jsonOutputGenerator(){
        return new JsonOutputGenerator();
    }

    @Bean(name = "csvOutputGenerator")
    public CsvOutputGenerator csvOutputGenerator(){
        return new CsvOutputGenerator();
    }
}
