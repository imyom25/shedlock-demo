package com.example.shedlock;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTaskTrigger {

    @Scheduled(cron = "0 0 20 * * ?")
    @SchedulerLock(name = "TaskScheduler_scheduledTask",
            lockAtLeastForString = "PT5M", lockAtMostForString = "PT14M")
    public void scheduledTask() {
        System.out.println("starting application"+ Thread.currentThread().getName());
        System.out.println("Demo task");
        System.out.println("end application"+ Thread.currentThread().getName());
    }
}
