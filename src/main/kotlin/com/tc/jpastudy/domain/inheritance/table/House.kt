package com.tc.jpastudy.domain.inheritance.table

import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "house_type")
abstract class House(
    var floor: Int?
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Long? = null
}
