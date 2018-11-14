package com.dlut.output;

import com.dlut.Aspectj.annotation.Action;
import com.dlut.output.impl.CsvOutputGenerator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class OutputHelper {
    /**
     * 当Spring无法找到匹配的Bean装配，它会抛出异常。要解决这个问题，
     * 可以通过 @Autowired 的“required”属性设置为false来禁用此检查功能。
     */
    //@Autowired(required = false)

    public IOutputGenerator getOutputGenerator() {
        return outputGenerator;
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }

    /**
     * 通过 @Autowired 自动装配 bean，它可以在 setter 方法，构造函数或字段中使用。
     * 使用 @Autowired 注解进行装配，只能是根据类型进行匹配。
     */
    IOutputGenerator outputGenerator;

    public OutputHelper(){

    }

    public OutputHelper(IOutputGenerator iOutputGenerator){
        this.outputGenerator = iOutputGenerator;
    }


    @Action(name = "")
    public void generateOutput() {
        outputGenerator.generateOutput();
    }

    /*public void setOutputGenerator(IOutputGenerator outputGenerator){
        System.out.println("执行setOutputGenerator操作!!!");
        this.outputGenerator = outputGenerator;
    }*/

    public void init()
    {
        System.out.println("OutputHelper  init!!!");
    }

    public void destory()
    {
        System.out.println("OutputHelper destory!!!");
    }
}
