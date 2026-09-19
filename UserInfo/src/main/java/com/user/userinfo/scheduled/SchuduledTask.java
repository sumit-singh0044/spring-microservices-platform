package com.user.userinfo.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchuduledTask {


    private static final Logger log = LoggerFactory.getLogger(SchuduledTask.class);

//    @Scheduled(fixedRate = 5000)
//    public void performTask() {
//        log.info("Scheduled task executed at: " + System.currentTimeMillis());
//        System.out.println("Scheduled task executed at: " + System.currentTimeMillis());
//
//    }

}
