package com.example.bootstatrt.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 放在容器，需要在容器启动的时候执行一些内容。比如读取配置文件，
 * 数据库连接之类的。SpringBoot给我们提供了两个接口来帮助我们实现这种需求
 */

@Component
public class HelloCommandLinerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("HelloCommandLinerRunner+++++++run"+ Arrays.asList(args));
    }
}
