package com.tc.jpastudy

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TcJpaStudyApplication : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

    }
}

fun main(args: Array<String>) {
    runApplication<TcJpaStudyApplication>(*args)
}
