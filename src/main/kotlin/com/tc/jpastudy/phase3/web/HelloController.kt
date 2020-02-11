package com.tc.jpastudy.phase3.web

import com.tc.jpastudy.ThreadLocalContext
import com.tc.jpastudy.phase3.Box
import com.tc.jpastudy.phase3.BoxRepo
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/hello")
class HelloController(
    private val boxRepo: BoxRepo,
    private val myService: MyService
) {

    @GetMapping
    fun hello(pageable: Pageable): String {
        boxRepo.findAll(pageable)
        return pageable.toString()
    }

    // /hello/123
    @Transactional
    @GetMapping("/{id}")
    fun helloId(@PathVariable("id") id: Long): String {
        println("data1 :::::::: ${ThreadLocalContext.userLocal.get()}")
        println("data1 :::::::: ${ThreadLocalContext.data}")
        val box = boxRepo.saveAndFlush(Box().apply { name = "zzzz" })

        val serviceBox = myService.findById(box.id!!)
        serviceBox.name = "ddd"

        println("data2 :::::::: ${ThreadLocalContext.userLocal.get()}")
        println("data2 :::::::: ${ThreadLocalContext.data}")

        return box.name
    }

    @ExceptionHandler
    fun handleEntityNotFound(ex: EntityNotFoundException): String {
        return ex.localizedMessage
    }
}
