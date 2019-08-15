package com.example.amqp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 监听队列，消费消息
 */
@Service
public class MqListener {
    @RabbitListener(queues = "atguigu.news")
    public void myReceive(Map map){
        System.out.println("--------------->"+map.toString());
    }
}
