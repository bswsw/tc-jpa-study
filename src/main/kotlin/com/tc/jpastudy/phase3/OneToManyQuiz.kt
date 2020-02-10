package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

/**
 * 1. 양방향 관계에서 빠진거 찾기
 */
@Entity
class NintendoSwitch(
    var owner: String
) : BaseEntity<Long>() {

    @OneToMany
    val titles: MutableSet<GameTitle> = mutableSetOf()
}

@Entity
class GameTitle(
    var name: String
) : BaseEntity<Long>() {

    @ManyToOne
    var switch: NintendoSwitch? = null
}

// ==========================================================

