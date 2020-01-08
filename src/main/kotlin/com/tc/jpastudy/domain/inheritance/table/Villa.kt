package com.tc.jpastudy.domain.inheritance.table

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("villa")
class Villa(
    floor: Int?,
    var hasElevator: String?
) : House(floor)
