package com.tc.jpastudy.domain.inheritance.table

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("apt")
class Apartment(
    floor: Int?,
    var hasGuard: String?
) : House(floor)
