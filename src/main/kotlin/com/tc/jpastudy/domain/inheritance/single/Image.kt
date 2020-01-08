package com.tc.jpastudy.domain.inheritance.single

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("image")
class Image(
    ext: String,
    var width: Int,
    var height: Int
) : Data(ext)
