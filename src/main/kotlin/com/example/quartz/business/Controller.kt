package com.example.quartz.business

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(private val service: Service) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/findActiveBuyer")
    fun getActiveBuyer() = service.getResponse()

    @GetMapping("/testAsync")
    fun getBuyerAndSeller(): JsonResponse {
        log.info("Async request started.")
        service.getInfo()
        log.info("json response.")
        return JsonResponse()
    }

}