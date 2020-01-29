package com.tc.jpastudy.repository.student

import com.tc.jpastudy.repository.base.BaseEntity
import com.tc.jpastudy.repository.classroom.Classroom
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class Student(
    var name: String,
    var age: Int
) : BaseEntity<Long>() {

    @ManyToOne(fetch = FetchType.LAZY)
    var room: Classroom? = null
        set(value) {
            field = value
            value!!.students.add(this)
        }
}

interface StudentRepository : JpaRepository<Student, Long>
