package com.tc.jpastudy.repository

import com.tc.jpastudy.domain.context.Member
import com.tc.jpastudy.domain.context.MemberRepository
import com.tc.jpastudy.domain.context.Team
import com.tc.jpastudy.domain.context.TeamRepository
import com.tc.jpastudy.repository.classroom.ClassroomRepository
import com.tc.jpastudy.repository.lecture.LectureRepository
import com.tc.jpastudy.repository.student.StudentRepository
import com.tc.jpastudy.repository.teacher.TeacherRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.TestConstructor
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Rollback(false)
internal class RepositoryTest(
    private val lectureRepository: LectureRepository,
    private val classroomRepository: ClassroomRepository,
    private val teacherRepository: TeacherRepository,
    private val studentRepository: StudentRepository,
    private val memberRepository: MemberRepository,
    private val teamRepository: TeamRepository
) {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Test
    @DisplayName("테스트")
    fun test() {
        // todo
    }
}
