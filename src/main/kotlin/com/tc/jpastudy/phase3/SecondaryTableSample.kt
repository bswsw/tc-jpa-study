package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.SecondaryTable
import javax.persistence.SecondaryTables

/**
 * table1
 *
 * id: pk
 * name: varchar
 */

/**
 * table2
 *
 * id: pk, fk -- table1.pk
 * col1: varchar
 * col2: varchar
 */
@Entity
@SecondaryTable(name = "sub_data", pkJoinColumns = [PrimaryKeyJoinColumn(name = "id")])
class MainData : BaseEntity<Long>() {
    var name: String = ""
}

@Embeddable
data class SubData(
    val col1: String,
    val col2: String
)
