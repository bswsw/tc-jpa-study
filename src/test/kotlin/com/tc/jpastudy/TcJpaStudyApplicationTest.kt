package com.tc.jpastudy

import com.tc.jpastudy.domain.Zone
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor
import java.time.LocalTime
import javax.persistence.EntityManagerFactory
import javax.persistence.FlushModeType

@ExtendWith
@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class TcJpaStudyApplicationTest(
    private val emf: EntityManagerFactory
) {

    @Test
    @DisplayName("JPA 저장 테스트")
    fun testPersist() {
        val em = emf.createEntityManager()
        em.flushMode = FlushModeType.COMMIT
        val tx = em.transaction

        tx.begin()

        val zone = Zone(
            name = "쏘카존",
            address = "서울시 성동구",
            openTime = LocalTime.of(9, 0, 0),
            closeTime = LocalTime.of(22, 0, 0)
        )

        println("=============================")
        em.persist(zone)
        println("=============================")

        tx.commit()
        em.close()

        assertThat(zone.id).isNotNull()
    }

    @Test
    @DisplayName("JPA 조회 테스트")
    fun testFind() {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        em.find(Zone::class.java, 1L)

        tx.commit()
        em.close()
    }

    @Test
    @DisplayName("엔티티매니저 동일성 테스트")
    fun testIdentity() {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        val zone = Zone(
            name = "쏘카존_${(1000..2000).random()}",
            address = "서울시 성동구",
            openTime = LocalTime.of(9, 0, 0),
            closeTime = LocalTime.of(22, 0, 0)
        )

        println("===========================")
        em.persist(zone)
        println("===========================")

        val findZone = em.find(Zone::class.java, zone.id)
        assertThat(zone).isEqualTo(findZone)

        tx.commit()
        em.close()
    }

    @Test
    @DisplayName("JPA 업데이트 테스트")
    fun testUpdate() {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        val zone = Zone(
            name = "쏘카존_${(1000..2000).random()}",
            address = "서울시 성동구",
            openTime = LocalTime.of(9, 0, 0),
            closeTime = LocalTime.of(22, 0, 0)
        )

        println("===========================")
        em.persist(zone)
        println("===========================")

        tx.commit()
        // 엔티티매니저 비우기
        em.clear()

        // ---------------------------------------------

        tx.begin()

        val findZone = em.find(Zone::class.java, zone.id)
        findZone.address = "서울시 구로구"

        tx.commit()
        em.close()
    }

    @Test
    @DisplayName("JPA 삭제 테스트")
    fun testDelete() {
        val em = emf.createEntityManager()
        val tx = em.transaction

        tx.begin()

        val zone = Zone(
            name = "쏘카존_${(1000..2000).random()}",
            address = "서울시 성동구",
            openTime = LocalTime.of(9, 0, 0),
            closeTime = LocalTime.of(22, 0, 0)
        )

        em.persist(zone)

        tx.commit()
        // 엔티티매니저 비우기
        em.clear()

        // ---------------------------------------------

        tx.begin()

        val findZone = em.find(Zone::class.java, zone.id)
        em.remove(findZone)

        tx.commit()
        em.close()
    }
}

// transaction
// val em = emf.createEntityManager()
// val tx = em.transaction
//
// try {
//     tx.begin()
//     // persist
//     tx.commit()
// } catch (e: Exception) {
//     e.printStackTrace()
//     tx.rollback()
// } finally {
//     em.close()
// }
