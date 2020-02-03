package com.tc.jpastudy.repository.teacher

import com.tc.jpastudy.repository.common.PersonalInformation
import com.tc.jpastudy.repository.base.BaseEntity
import javax.persistence.AttributeOverride
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity

@Entity
class Teacher(
    personalInfo: PersonalInformation
) : BaseEntity<Long>() {

    @Embedded
    @AttributeOverride(name = "name", column = Column(name = "teacher_name"))
    var personalInfo: PersonalInformation = personalInfo
}
