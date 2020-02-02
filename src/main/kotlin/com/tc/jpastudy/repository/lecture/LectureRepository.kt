package com.tc.jpastudy.repository.lecture

import com.tc.jpastudy.repository.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository : JpaRepository<Lecture, Long>
