package com.tc.jpastudy

import com.tc.jpastudy.domain.Car
import com.tc.jpastudy.domain.Zone
import com.tc.jpastudy.domain.inheritance.join.Book
import com.tc.jpastudy.domain.inheritance.single.Image
import com.tc.jpastudy.domain.inheritance.single.Zip
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalTime
import javax.persistence.EntityManagerFactory

@SpringBootApplication
class TcJpaStudyApplication(
    private val emf: EntityManagerFactory
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        println("==-")
        // val img = Zip("zip", 10)
        // em.persist(img)
        println("==-")

        tx.commit()
        em.clear()

        tx.begin()
        // em.find(Car::class.java, 1L)

        val z1 = Zone("asdsa", "asdad", LocalTime.now(), LocalTime.now())
        val z2 = Zone("asdsa", "asdad", LocalTime.now(), LocalTime.now())
        val z3 = Zone("asdsa", "asdad", LocalTime.now(), LocalTime.now())

        val c1 = Car(z1, "asd")
        val c2 = Car(z2, "asd")
        val c3 = Car(z3, "asd")

        em.persist(z1)
        em.persist(z2)
        em.persist(z3)

        em.persist(c1)
        em.persist(c2)
        em.persist(c3)

        em.clear()

        // n + 1
        em.createQuery("SELECT c FROM Car c JOIN FETCH c.zone", Car::class.java).resultList.forEach {
            it.zone.address
        }
    }
}

fun main(args: Array<String>) {
    runApplication<TcJpaStudyApplication>(*args)
}

class Mydata(val data1: Int, val data2: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Mydata

        if (data1 != other.data1) return false
        if (data2 != other.data2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data1
        result = 31 * result + data2
        return result
    }
}

