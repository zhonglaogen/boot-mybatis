package com.zlx.bootmybatis.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过ConfigurationCustomizer设置mybatis的定制规则
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰命名规则，将select × 查到的数据映射到pojo，只作用于注解版
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
