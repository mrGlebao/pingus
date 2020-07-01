package com.glebus.pingus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class MailSenderApplication

fun main(args: Array<String>) {
    runApplication<MailSenderApplication>(*args)
}