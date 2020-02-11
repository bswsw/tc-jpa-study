package com.tc.jpastudy.phase3

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.PersistenceContext

@Entity
class Cloth(
    @Id
    var id: Long,
    var name: String
)

@Entity
class Delivery(
    @Id
    var id: Long,
    var name: String,
    @ManyToOne
    var cloth: Cloth
)

@Component
class JPQLQuiz : ApplicationRunner {

    @PersistenceContext
    private lateinit var em: EntityManager

    override fun run(args: ApplicationArguments?) {
        em.createQuery("SELECT d FROM Delivery d WHERE d.name = 'ss'", Delivery::class.java).resultList.forEach {
            // 아래 주석을 풀면 에러인 이유는?
            // it.name
        }
    }
}

