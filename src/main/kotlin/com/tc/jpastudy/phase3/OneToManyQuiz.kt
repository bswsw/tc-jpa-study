package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.PersistenceContext

/**
 * 1. 양방향 관계에서 빠진거 찾기
 */
@Entity
class NintendoSwitch(
    var owner: String
) : BaseEntity<Long>() {

    @OneToMany(mappedBy = "switch")
    val titles: MutableSet<GameTitle> = mutableSetOf()
}

@Entity
class GameTitle(
    var name: String
) : BaseEntity<Long>() {

    @ManyToOne(fetch = FetchType.LAZY)
    var switch: NintendoSwitch? = null
}

// ==========================================================

@Component
@Transactional
class Runner : ApplicationRunner {
    @PersistenceContext
    lateinit var em: EntityManager

    override fun run(args: ApplicationArguments?) {
        println("===================================")

        (0..20).forEach {
            val switch = NintendoSwitch(owner = "배군_$it")
            val title = GameTitle(name = "젤다_$it")

            switch.titles.add(title)
            title.switch = switch

            em.persist(switch)
            em.persist(title)
        }
    }
}
