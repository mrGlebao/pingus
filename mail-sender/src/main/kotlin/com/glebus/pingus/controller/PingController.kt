package com.glebus.pingus.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PingController {
    @RequestMapping("/ping")
    fun index(): String {
        return "pong"
    }
}