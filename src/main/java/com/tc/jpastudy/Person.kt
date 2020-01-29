package com.tc.jpastudy

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Person {
    @Id
    var id: Long? = null
    var name: String? = null

}
