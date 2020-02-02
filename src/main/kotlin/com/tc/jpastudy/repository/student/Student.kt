package com.tc.jpastudy.repository.student

import com.tc.jpastudy.repository.common.PersonalInformation
import com.tc.jpastudy.repository.base.BaseEntity
import com.tc.jpastudy.repository.lecture.Lecture
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class Student(
    val email: String,
    @Embedded
    val personalInfo: PersonalInformation
) : BaseEntity<Long>() {

    @ManyToOne(fetch = FetchType.LAZY)
    var lecture: Lecture? = null
        protected set

    fun addLecture(lecture: Lecture) {
        this.lecture = lecture
        lecture.students.add(this)
    }
}
