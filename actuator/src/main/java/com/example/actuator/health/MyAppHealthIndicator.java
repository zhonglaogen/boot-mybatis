package com.example.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        //自定义检查方法
        //Health.up().build()代表健康,
        //Health.down().withDetail("msg","服务异常").build()
        return Health.up().build();
    }
}
