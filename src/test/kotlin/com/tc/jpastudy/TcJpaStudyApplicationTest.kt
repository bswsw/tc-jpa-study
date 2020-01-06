package com.tc.jpastudy

import com.tc.jpastudy.domain.Zone
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor
import java.time.LocalTime
import javax.persistence.EntityManagerFactory

@ExtendWith
@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class TcJpaStudyApplicationTest(
    private val emf: EntityManagerFactory
) {

    @Test
    @DisplayName("JPA 저장 테스트")
    fun testPersist() {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        try {
            val zone = Zone(
                name = "쏘카존",
                address = "서울시 성동구",
                openTime = LocalTime.of(9, 0, 0),
                closeTime = LocalTime.of(22, 0, 0)
            )

            em.persist(zone)

            println("Zone Id : ${zone.id}")

            tx.commit()
        } catch (e: Exception) {
            e.printStackTrace()
            tx.rollback()
        } finally {
            em.close()
        }
    }

    @Test
    @DisplayName("JPA 조회 테스트")
    fun testFind() {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        try {
            val zone = em.find(Zone::class.java, 1)

            println("ZONE :: $zone")

            tx.commit()
        } catch (e: Exception) {
            e.printStackTrace()
            tx.rollback()
        } finally {
            em.close()
        }
    }
}
