package com.example.quartz.business.config

import com.example.quartz.business.ActivateBuyerQuartz
import org.jetbrains.annotations.TestOnly
import org.quartz.*
import org.quartz.impl.StdSchedulerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.quartz.SpringBeanJobFactory

@Configuration
class QuartzConfig(
    private val springBeanJobFactory: SpringBeanJobFactory
) {
    @Bean
    fun initQuartz() {
        mutableListOf<JobDetail>().apply {
            add(
                JobBuilder.newJob(ActivateBuyerQuartz::class.java)
                    .withIdentity("ActivateBuyerQuartz")
                    .build()
            )
        }.apply {
            startJobs(this)
        }
    }

    private fun createTrigger(): Trigger =
        TriggerBuilder.newTrigger().withSchedule(
            CronScheduleBuilder.cronSchedule("0 0 3 * * ?")
        ).build()

    @TestOnly
    private fun createTestTrigger(): Trigger =
        TriggerBuilder.newTrigger().startNow().build()

    private fun startJobs(jobList: MutableList<JobDetail>) {
        StdSchedulerFactory.getDefaultScheduler().apply {
            setJobFactory(springBeanJobFactory)
            jobList.forEach {
                scheduleJob(it, createTestTrigger())
            }
            start()
        }
    }
}