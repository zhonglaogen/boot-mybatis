package com.example.bootstatrt.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 放在容器，需要在容器启动的时候执行一些内容。比如读取配置文件，
 * 数据库连接之类的。SpringBoot给我们提供了两个接口来帮助我们实现这种需求
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("HelloApplicationRunner+++++++++++run");
    }
}
