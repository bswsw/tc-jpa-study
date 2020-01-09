package com.tc.jpastudy.domain

import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Zone(
    var name: String,
    var address: String,
    var openTime: LocalTime,
    var closeTime: LocalTime
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "zone")
    val cars: MutableSet<Car> = mutableSetOf()

    override fun toString(): String {
        return "Zone(name='$name', address='$address', openTime=$openTime, closeTime=$closeTime, id=$id)"
    }
}
