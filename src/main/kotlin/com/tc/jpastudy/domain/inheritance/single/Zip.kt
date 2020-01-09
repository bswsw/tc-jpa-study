package com.tc.jpastudy.domain.inheritance.single

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("zip")
class Zip(
    ext: String,
    var rate: Int
) : Data(ext)
