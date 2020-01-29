package com.tc.jpastudy.domain.context

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Team(
    @Id
    var id: Long,
    var name: String
)
