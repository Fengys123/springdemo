package com.dlut.Config;

import com.dlut.Aspectj.LogAspectj;
import com.dlut.el.DemoService;
import com.dlut.output.IOutputGenerator;
import com.dlut.output.OutputHelper;
import com.dlut.output.Profile.demoBean;
import com.dlut.output.impl.CsvOutputGenerator;
import com.dlut.output.impl.JsonOutputGenerator;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.dlut")
//使用该注解开启Spring对Aspectj代理的支持
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class app implements AsyncConfigurer {
    @Bean(name = "outputHelper1",initMethod = "init",destroyMethod = "destory")
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

    @Bean
    public LogAspectj logAspectj(){
        return new LogAspectj();
    }

    @Bean
    @Profile("dev")
    public demoBean devDemoBean()
    {
        return  new demoBean("From development profile");
    }

    @Bean
    @Profile("prod")
    public demoBean proDemoBean()
    {
        return new demoBean("From production profile");
    }

    @Override
    public Executor getAsyncExecutor() {
        //这个类的作用是什么 不清楚 之后在做研究
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
