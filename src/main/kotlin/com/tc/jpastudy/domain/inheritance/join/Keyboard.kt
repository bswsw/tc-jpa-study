package com.tc.jpastudy.domain.inheritance.join

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("keyboard")
class Keyboard(
    name: String,
    var keyCount: Int
) : Item(name)
