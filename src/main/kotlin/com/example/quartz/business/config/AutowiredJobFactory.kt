package com.example.quartz.business.config

import org.quartz.spi.TriggerFiredBundle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.scheduling.quartz.SpringBeanJobFactory

class AutowiredJobFactory : SpringBeanJobFactory(), ApplicationContextAware {
    @Autowired
    private lateinit var capableBeanFactory: AutowireCapableBeanFactory

    override fun setApplicationContext(context: ApplicationContext) {
        capableBeanFactory = context.autowireCapableBeanFactory
    }

    override fun createJobInstance(bundle: TriggerFiredBundle): Any {
        val job = super.createJobInstance(bundle)
        capableBeanFactory.autowireBean(job)
        return job
    }
}
