package com.tc.jpastudy

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaStudyApplication(
    private val itemRepo: ItemRepo
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        itemRepo.save(
            Item(address = "sadad")
        )
    }
}

fun main(args: Array<String>) {
    runApplication<JpaStudyApplication>(*args)
}
