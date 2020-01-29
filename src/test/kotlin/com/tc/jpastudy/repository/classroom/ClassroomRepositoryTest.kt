package com.tc.jpastudy.repository.classroom

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class ClassroomRepositoryTest(
    private val classroomRepository: ClassroomRepository
) {

    @Test
    @DisplayName("교실 조회")
    fun `find classroom`() {
        classroomRepository.findById(123)
    }
}
