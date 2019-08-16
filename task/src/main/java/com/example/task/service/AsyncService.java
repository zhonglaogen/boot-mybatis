package com.example.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 遇到发送短信这样的异步任务,不会阻塞下面的事情
 */
@Service
public class AsyncService {
    //spring自己在开线程池调用,这是一个异步方法
    @Async
    public void hello(){
        try{ TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){ e.printStackTrace();}
        System.out.println("hello");
    }

}
