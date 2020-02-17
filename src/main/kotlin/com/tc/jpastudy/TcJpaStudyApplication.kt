package com.tc.jpastudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class TcJpaStudyApplication

fun main(args: Array<String>) {
    runApplication<TcJpaStudyApplication>(*args)
}
