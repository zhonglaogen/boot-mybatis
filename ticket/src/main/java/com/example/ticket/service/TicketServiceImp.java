package com.example.ticket.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
//将服务发布出去
@Service
public class TicketServiceImp implements TicketService {
    @Override
    public String getTicket() {
        return "<<dsadsadsadasd>>";
    }
}
