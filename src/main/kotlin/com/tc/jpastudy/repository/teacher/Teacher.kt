package com.tc.jpastudy.repository.teacher

import com.tc.jpastudy.repository.base.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity

@Entity
class Teacher(
    var name: String,
    var age: Int
) : BaseEntity<Long>()

interface TeacherRepository : JpaRepository<Teacher, Long>
