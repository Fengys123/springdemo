package com.dlut.output;

import com.dlut.Aspectj.annotation.Action;

public interface IOutputGenerator {
    //有个疑问 这个注解为什么一定要标在借口上
    @Action(name = "注解式的拦截操作")
    public void generateOutput();
}
