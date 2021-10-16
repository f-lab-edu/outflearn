package kr.flab.outflearn.student.domain.repository

import kr.flab.outflearn.createCourse
import kr.flab.outflearn.createMember
import kr.flab.outflearn.createStudent
import kr.flab.outflearn.createTeacher
import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.student.domain.EnrollStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql

@Sql("classpath:data/data.sql")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class EnrollRepositoryTest {

    @Autowired
    lateinit var enrollRepository: EnrollRepository

    @Test
    fun `학생이 수강중인 강의를 조회한다`() {
        // given
        val member = createMember(id = 101)
        val teacher201 = createTeacher(id = 201)
        val teacher202 = createTeacher(id = 202)
        val enroll101 = Enroll(
            createStudent(id = 101, member = member),
            createCourse(id = 101, teacher = teacher201),
            EnrollStatus.REGISTERED
        )
        val enroll102 = Enroll(
            createStudent(id = 101, member = member),
            createCourse(id = 102, teacher = teacher202),
            EnrollStatus.REGISTERED
        )

        enrollRepository.saveAll(listOf(enroll101, enroll102));

        // when
        val findByStudent = enrollRepository.findByStudent(createStudent(id = 101))

        // then
        assertThat(findByStudent).hasSize(2)
        assertThat(findByStudent).containsExactly(enroll101, enroll102)
    }
}
