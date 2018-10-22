package com.dlut.output;

import com.dlut.output.impl.CsvOutputGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class OutputHelper {
    /**
     * 当Spring无法找到匹配的Bean装配，它会抛出异常。要解决这个问题，
     * 可以通过 @Autowired 的“required”属性设置为false来禁用此检查功能。
     */
    //@Autowired(required = false)
    /**
     * 通过 @Autowired 自动装配 bean，它可以在 setter 方法，构造函数或字段中使用。
     * 使用 @Autowired 注解进行装配，只能是根据类型进行匹配。
     */
    IOutputGenerator outputGenerator;



    public OutputHelper(){
        //outputGenerator = new CsvOutputGenerator();
    }


    public void generateOutput(){
        outputGenerator.generateOutput();
    }

    /*public void setOutputGenerator(IOutputGenerator outputGenerator){
        System.out.println("执行setOutputGenerator操作!!!");
        this.outputGenerator = outputGenerator;
    }*/
}
