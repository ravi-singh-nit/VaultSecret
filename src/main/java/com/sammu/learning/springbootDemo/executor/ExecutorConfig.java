package com.sammu.learning.springbootDemo.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ExecutorConfig {
    @Bean(name = "appExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(3);        // minimum threads
        executor.setMaxPoolSize(5);         // maximum threads
        executor.setQueueCapacity(5);       // waiting queue
        executor.setThreadNamePrefix("app-exec-");
        executor.setKeepAliveSeconds(60);

        executor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.initialize();
        return executor;
    }
}
