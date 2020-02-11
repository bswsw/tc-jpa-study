package com.tc.jpastudy

import com.tc.jpastudy.phase3.Anything
import com.tc.jpastudy.phase3.Box
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@DataJpaTest
class Phase3Test {

    @PersistenceContext
    lateinit var em: EntityManager

    @Test
    fun test() {
        val box = Box().apply {
            this.name = "박스이름"
        }

        var thing: Anything? = null
        (0..10).forEach {
            box.things.add(Anything(name = "띵_$it", size = it))
        }

         em.persist(box)

        em.flush()

        println("=====================")

        box.things.removeAt(1)

        em.flush()

        em.remove(box)

        println("====================111=")
        em.flush()
    }
}
