package com.dgkncgty.demo.spring.shedlock.shedlockzkdemo;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.zookeeper.curator.ZookeeperCuratorLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "0s")
public class TasksConfig {

    private Logger log = LoggerFactory.getLogger(TasksConfig.class);

    @Bean
    public LockProvider lockProvider(org.apache.curator.framework.CuratorFramework client) {
        return new ZookeeperCuratorLockProvider(client);
    }

    @Scheduled(cron = "*/5 * * * * *")
    @SchedulerLock(name = "scheduledTask")
    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

}
