package com.tc.jpastudy.repository.lecture

import com.tc.jpastudy.repository.base.BaseEntity
import com.tc.jpastudy.repository.classroom.Classroom
import com.tc.jpastudy.repository.student.Student
import com.tc.jpastudy.repository.teacher.Teacher
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Lecture(
    @Column(name = "lecture_name")
    val name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val room: Classroom,
    @ManyToOne(fetch = FetchType.LAZY)
    val teacher: Teacher
) : BaseEntity<Long>() {

    @OneToMany(mappedBy = "lecture")
    val students: MutableSet<Student> = mutableSetOf()

    @Enumerated(EnumType.STRING)
    var state: LectureState = LectureState.OPENED
}
