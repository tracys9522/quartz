package com.example.quartz.business

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(private val service: Service) {
    @GetMapping("/findActiveBuyer")
    fun getActiveBuyer() = service.getResponse()

}