package com.tc.jpastudy.repository.teacher

import com.tc.jpastudy.repository.common.PersonalInformation
import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.Embedded
import javax.persistence.Entity

@Entity
class Teacher(
    @Embedded
    val personalInfo: PersonalInformation
) : BaseEntity<Long>()
