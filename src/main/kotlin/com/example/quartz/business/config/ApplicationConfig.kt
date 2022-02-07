package com.example.quartz.business.config

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.quartz.SpringBeanJobFactory

@Configuration
class ApplicationConfig(private val context: ApplicationContext) {
    @Bean
    fun springBeanJobFactory() = AutowiredJobFactory().apply {
        this.setApplicationContext(context)
    }
}
