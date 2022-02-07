package com.example.quartz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
open class QuartzApplication

fun main(args: Array<String>) {
	runApplication<QuartzApplication>(*args)
}
