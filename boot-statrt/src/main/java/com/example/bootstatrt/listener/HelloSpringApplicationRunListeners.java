package com.example.bootstatrt.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 加载springfactory的listener组件
 */
public class HelloSpringApplicationRunListeners implements SpringApplicationRunListener {


    public HelloSpringApplicationRunListeners(SpringApplication application, String[] args){

    }
    @Override
    public void starting() {
        System.out.println("HelloSpringApplicationRunListeners++++++++start");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("HelloSpringApplicationRunListeners++++++environmentPrepared"+o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListeners++++++++++++contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

        System.out.println("HelloSpringApplicationRunListeners+++++++++contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {

        System.out.println("HelloSpringApplicationRunListeners+++++++++++++++==started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {

        System.out.println("HelloSpringApplicationRunListeners+++++++++++++++++++++running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

        System.out.println("HelloSpringApplicationRunListeners+++++++++failed");
    }
}
