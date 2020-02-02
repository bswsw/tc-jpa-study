package com.tc.jpastudy

import com.tc.jpastudy.domain.context.Member
import com.tc.jpastudy.domain.context.Team
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@DisplayName("영속성 컨텍스트 테스트")
internal class PersistenceContextTest {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Test
    @DisplayName("1차 캐시 테스트")
    fun testFirstLevelCache() {
        val randomNum = (100..200L).random()

        val team = Team(
            id = randomNum,
            name = "팀_$randomNum"
        )

        em.persist(team)

        // select 쿼리가 실행되지 않고 1차 캐시에서 가져옴.
        em.find(Team::class.java, team.id)
    }

    @Test
    @DisplayName("동일성 테스트")
    fun testIdentity() {
        val randomNum = (100..200L).random()

        val team = Team(
            id = randomNum,
            name = "팀_$randomNum"
        )

        em.persist(team)

        // select 쿼리가 실행되지 않고 1차 캐시에서 가져옴.
        val findTeam = em.find(Team::class.java, team.id)

        // 동등성 (equality)
        assertEquals(findTeam, team)
        // 동일성 (identity)
        assertSame(findTeam, team)
    }

    @Test
    @DisplayName("쓰기 지연 테스트")
    fun testWriteBehind() {
        println("========================")

        val team = Team(
            id = 12113123L,
            name = "팀_지연"
        )

        // 쿼리가 출력문 사이에 찍히지 않고 트랜젝션이 커밋될 때 (메소드 끝) 찍힘
        em.persist(team)

        println("========================")
    }

    @Test
    @DisplayName("변경 감지 테스트")
    fun testDirtyChecking() {
        val randomNum = (100..200L).random()

        val team = Team(
            id = randomNum,
            name = "팀_$randomNum"
        )

        em.persist(team)

        // 프로퍼티의 값을 변경만 하면 종료 전 변경된 사항을 커밋할떄 판단하여 update 쿼리 실행
        team.name = "TD"
    }

    @Test
    @DisplayName("지연 로딩 테스트")
    fun testLazyLoading() {
        val randomNum = (100..200L).random()

        val team = Team(
            id = randomNum,
            name = "팀_$randomNum"
        )

        val member = Member(
            id = randomNum,
            team = team,
            name = "배모군_$randomNum",
            address = "서울_$randomNum"
        )

        em.persist(team)
        em.persist(member)

        // flush를 실행하면 쌓인 쿼리를 실행합니다.
        em.flush()
        // clear를 실행하면 영속성 컨텍스트가 가지고 있는 엔티티를 모두 제거합니다. (1차 캐시 정리)
        em.clear()

        val findMember = em.find(Member::class.java, member.id)

        println("Member에서 Team을 참조하기 전 : ${findMember.address}")

        // team을 참조할 때 team select 쿼리가 실행됨
        println("==================")
        println("Member에서 Team 참조 : ${findMember.team.name}")
        println("==================")
    }
}
