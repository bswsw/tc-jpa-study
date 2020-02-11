package com.tc.jpastudy.phase3.web

import com.tc.jpastudy.ThreadLocalContext
import com.tc.jpastudy.phase3.Box
import com.tc.jpastudy.phase3.BoxRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class MyService(
    private val boxRepo: BoxRepo
) {

    @Transactional
    fun findById(id: Long): Box {
        ThreadLocalContext.userLocal.set("zzzzz")
        ThreadLocalContext.data = "zzzzz"

        val box = boxRepo.findByIdOrNull(id) ?: throw EntityNotFoundException("없어")
        box.name = "zzz"
        return box
    }
}
