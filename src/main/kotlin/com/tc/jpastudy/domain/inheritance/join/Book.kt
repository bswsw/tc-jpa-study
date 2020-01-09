package com.tc.jpastudy.domain.inheritance.join

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("book")
class Book(
    name: String,
    var author: String // 저자
) : Item(name)
