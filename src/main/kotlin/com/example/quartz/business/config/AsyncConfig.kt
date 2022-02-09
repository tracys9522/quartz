package com.example.quartz.business.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor

@EnableAsync
@Configuration
class AsyncConfig {
    @Bean(name = ["asyncPoolTaskExecutor"])
    fun myTaskAsyncPool(): Executor {
        return ThreadPoolTaskExecutor().apply {
            corePoolSize = 10
            maxPoolSize = 100
            setQueueCapacity(50)
            keepAliveSeconds = 200
            setRejectedExecutionHandler(ThreadPoolExecutor.CallerRunsPolicy())
            initialize()
        }
    }
}