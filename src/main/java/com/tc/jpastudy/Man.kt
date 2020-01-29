package com.tc.jpastudy

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Man {
    @Id
    var id: Long? = null
    @ManyToOne(fetch = FetchType.LAZY)
    var person: Person? = null
}
