package com.dlut;

import com.dlut.output.IOutputGenerator;
import com.dlut.output.OutputHelper;
import com.dlut.output.impl.CsvOutputGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
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


        OutputHelper output2 = (OutputHelper)context.getBean("OutputHelper");
        output.generateOutput();
    }
}
