package com.tc.jpastudy.phase4.snack

import com.tc.jpastudy.phase4.BaseEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class SnackBaby(
    var name: String,
    var age: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    var snack: Snack
): BaseEntity()

