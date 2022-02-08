package com.example.quartz.business.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories("com.example.quartz.business.jpa")
@EnableTransactionManagement
class DatabaseConfiguration
