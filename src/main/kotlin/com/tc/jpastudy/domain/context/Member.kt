package com.tc.jpastudy.domain.context

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "MEMBER")
class Member(
    @Id
    var id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    var team: Team,
    var name: String,
    var address: String
)
