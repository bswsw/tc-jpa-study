package com.tc.jpastudy.repository.classroom

import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Classroom(
    @Column(name = "room_name")
    val name: String
) : BaseEntity<Long>() {

    var maxCount: Int = 10
        protected set
}
