package com.cyan.webservicetest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class WebservicetestApplication

fun main(args: Array<String>) {
    runApplication<WebservicetestApplication>(*args)
}
