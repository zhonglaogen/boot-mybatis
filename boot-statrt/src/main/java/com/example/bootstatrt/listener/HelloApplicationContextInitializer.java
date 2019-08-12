package com.example.bootstatrt.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 加载springfactorys的Initializer组件
 *监听IOC容器的启动（ConfigurableApplicationContext）
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("hello+++++++++++++++++++HelloApplicationContextInitializer++++Initializer"+configurableApplicationContext);
    }
}
