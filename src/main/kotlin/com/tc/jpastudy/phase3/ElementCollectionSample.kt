package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.Embeddable
import javax.persistence.Entity

/**
 * table1
 *
 * id: pk
 * name: varchar
 */

/**
 * table2
 *
 * table1_id: fk
 * name: varchar
 * age: int
 */

@Entity
class Box : BaseEntity<Long>() {
    var name: String = ""
}

@Embeddable
data class Anything(
    val name: String,
    val size: Int
)