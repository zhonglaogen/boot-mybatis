package com.example.user.service;

import com.example.ticket.service.TicketService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //发布时按照接口犬类名发布的,根据全类名匹配到注册中心的服务
    @Reference
    TicketService ticketService;

    public void hello(){
        System.out.println("拿到的东西是"+ticketService.getTicket());
    }
}
