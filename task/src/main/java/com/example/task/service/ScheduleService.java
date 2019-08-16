package com.example.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务Scheduled
 * minute, hour, day of month, month and day of week.
 * "0 * * * * MON-FRI"
 */
@Service
public class ScheduleService {
    @Scheduled(cron = "0 * * * * *")
    public void sayHello(){
        System.out.println("定时任务运行");
    }
}
