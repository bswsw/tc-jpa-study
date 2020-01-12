package com.tc.jpastudy

import com.tc.jpastudy.domain.Car
import com.tc.jpastudy.domain.Zone
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.Transactional
import java.time.LocalTime
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@SpringBootApplication
@Transactional
class TcJpaStudyApplication : ApplicationRunner {

    @PersistenceContext
    private lateinit var em: EntityManager

    override fun run(args: ApplicationArguments?) {
        val zone = Zone(
            name = "주차장",
            address = "서울시",
            openTime = LocalTime.now(),
            closeTime = LocalTime.now()
        )
        val car = Car(
            zone = zone,
            name = "벤츠"
        )

        em.persist(zone)
        em.persist(car)

        // n + 1
        em.createQuery("SELECT c FROM Car c JOIN FETCH c.zone", Car::class.java).resultList.forEach {
            it.zone.address
        }
    }
}

fun main(args: Array<String>) {
    runApplication<TcJpaStudyApplication>(*args)
}
