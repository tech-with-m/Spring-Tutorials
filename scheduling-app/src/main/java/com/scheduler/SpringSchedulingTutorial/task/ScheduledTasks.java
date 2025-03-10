package com.scheduler.SpringSchedulingTutorial.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
    
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    @Scheduled(fixedRate = 10000)
    public void executeFixedRateTask() {
        String currentTime = LocalDateTime.now().format(formatter);
        logger.info("Fixed Rate Task executed at: {}", currentTime);
    }
    
    @Scheduled(fixedDelay = 15000, initialDelay = 5000)
    public void executeFixedDelayTask() throws InterruptedException {
        Thread.sleep(1000);
        String currentTime = LocalDateTime.now().format(formatter);
        logger.info("Fixed Delay Task executed at: {}", currentTime);
    }
    
    @Scheduled(cron = "0 0 * * * ?")
    public void executeCronTask() {
        String currentTime = LocalDateTime.now().format(formatter);
        logger.info("Cron Task executed at: {}", currentTime);
    }
}
