package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.SecondaryTable
import javax.persistence.SecondaryTables

@Entity
@SecondaryTables(
    SecondaryTable(name = "accident_car", pkJoinColumns = [PrimaryKeyJoinColumn(name = "accident_id")]),
    SecondaryTable(name = "accident_driver", pkJoinColumns = [PrimaryKeyJoinColumn(name = "accident_id")])
)
class Accident : BaseEntity<Long>() {
    var state: String? = null

    @Embedded
    var car: AccidentCar? = null
    @Embedded
    var driver: AccidentDriver? = null
}

@Embeddable
data class AccidentCar(
    val carId: Long,
    val carNum: String
)

@Embeddable
data class AccidentDriver(
    val memberId: Long
)
