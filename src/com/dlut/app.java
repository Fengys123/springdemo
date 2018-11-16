package com.dlut;

import com.dlut.aware.AwareService;
import com.dlut.el.DemoService;
import com.dlut.event.DemoPublisher;
import com.dlut.output.OutputHelper;
import com.dlut.output.Profile.demoBean;
import com.dlut.taskExecutor.AsyncTaskService;
import com.dlut.taskscheduler.ScheduledTaskService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {
    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
        System.out.println();

        obj.setName("fys");
        obj.printHello();
        System.out.println();*/


        /**
         * 以这种方式，这个问题是“output”紧密到CsvOutputGenerator耦合，
         * 输出生成的每一个变化可能涉及代码变化。如果此代码分散在你的项目中，输出生成的每一次变化都会让你受苦。
         */
        /*IOutputGenerator output = new CsvOutputGenerator();
        output.generateOutput();
        System.out.println();*/


        //用一个辅助类调用他
        /*OutputHelper output1 = new OutputHelper();
        output1.generateOutput();
        System.out.println();*/

        /*OutputHelper output2 = (OutputHelper) context.getBean("beforeOutputMethodProxy");
        output2.generateOutput();
        System.out.println();*/


        /**
         * 现在，只需要改变 Spring XML 文件使用不同的输出生成器。只修改 Spring XML 文件而不需要无码修改，这意味着更少的错误。
         */
        ApplicationContext context1 = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext)context1).getEnvironment().setActiveProfiles("dev");
        ((AnnotationConfigApplicationContext)context1).register(com.dlut.Config.app.class);
        ((AnnotationConfigApplicationContext)context1).refresh();

        OutputHelper output3 = (OutputHelper)context1.getBean("outputHelper");
        output3.generateOutput();

        OutputHelper output4 = (OutputHelper)context1.getBean("outputHelper1");
        output4.generateOutput();

        DemoService demoService = (DemoService) context1.getBean("demoService");
        demoService.outputResource();

        demoBean demoBean = context1.getBean(com.dlut.output.Profile.demoBean.class);
        System.out.println(demoBean.getContent());

        DemoPublisher demoPublisher = context1.getBean(DemoPublisher.class);
        demoPublisher.publish("Java,次不刺激");

        AwareService awareService = context1.getBean(AwareService.class);
        awareService.outputResult();

        AsyncTaskService asyncTaskService = context1.getBean(AsyncTaskService.class);
        for(int i=0 ; i<10 ; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskplus(i);
        }

        //((AnnotationConfigApplicationContext) context1).close();

        //ApplicationContext context2 = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

    }
}
