package com.sammu.learning.springbootDemo.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExecutorMonitoring {

    @Autowired
    @Qualifier("appExecutor")
    private ThreadPoolTaskExecutor executor;

    @GetMapping("/executor/status")
    public Map<String,Object> executorStatus(){
        Map<String,Object> map = new HashMap<>();
        map.put("active", executor.getActiveCount());
        map.put("poolSize", executor.getPoolSize());
        map.put("queue", executor.getThreadPoolExecutor().getQueue().size());
        return map;
    }
}
