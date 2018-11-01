package com.dlut;

import com.dlut.output.IOutputGenerator;
import com.dlut.output.OutputHelper;
import com.dlut.output.impl.CsvOutputGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
        System.out.println();

        obj.setName("fys");
        obj.printHello();
        System.out.println();


        /**
         * 以这种方式，这个问题是“output”紧密到CsvOutputGenerator耦合，
         * 输出生成的每一个变化可能涉及代码变化。如果此代码分散在你的项目中，输出生成的每一次变化都会让你受苦。
         */
        IOutputGenerator output = new CsvOutputGenerator();
        output.generateOutput();
        System.out.println();


        //用一个辅助类调用他
        /*OutputHelper output1 = new OutputHelper();
        output1.generateOutput();
        System.out.println();*/

        OutputHelper output2 = (OutputHelper) context.getBean("beforeOutputMethodProxy");
        output2.generateOutput();
        System.out.println();


        /**
         * 现在，只需要改变 Spring XML 文件使用不同的输出生成器。只修改 Spring XML 文件而不需要无码修改，这意味着更少的错误。
         */
        ApplicationContext context1 = new AnnotationConfigApplicationContext(com.dlut.output.config.app.class);
        OutputHelper output3 = (OutputHelper)context1.getBean("outputHelper");
        output3.generateOutput();





    }
}
