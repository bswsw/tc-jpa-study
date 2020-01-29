package com.tc.jpastudy.repository.classroom

import com.tc.jpastudy.repository.base.BaseEntity
import com.tc.jpastudy.repository.student.Student
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Classroom(
    var count: Int
) : BaseEntity<Long>() {

    @OneToMany(mappedBy = "room", cascade = [CascadeType.ALL])
    val students: MutableSet<Student> = mutableSetOf()
}

interface ClassroomRepository : JpaRepository<Classroom, Long>
