package com.dlut.taskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTaskService {
    public void executeAsyncTask(Integer i)
    {
        System.out.println("执行异步任务~~~~~~~~~~~~~~~~~~~~~~~~:" + i);
    }

    @Async
    public void executeAsyncTaskplus(Integer i)
    {
        System.out.println("执行异步任务+1-----------:" + (i+1));
    }
}
