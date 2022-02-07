package com.example.quartz.business

import org.quartz.JobExecutionContext
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.quartz.QuartzJobBean
import org.springframework.stereotype.Component

@Component
class ActivateBuyerQuartz : QuartzJobBean() {
    private val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var service: Service

    override fun executeInternal(p0: JobExecutionContext) {
        val result = service.getResponse()
        log.info("$result")
    }
}