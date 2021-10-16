package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.createMember
import kr.flab.outflearn.createTeacher
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql

@Sql("classpath:data/data.sql")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class CourseRepositoryTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Test
    fun `강의 저장하기`() {
        // given
        val title = "멘토링"
        val fee = 3000
        val course = Course(title = title, fee = fee, teacher = createTeacher(member = createMember(id = 201), id = 201))
        assertThat(course.id).isNull()

        // when
        courseRepository.save(course)
        courseRepository.flush()

        // then
        assertThat(course.id).isNotNull
        assertThat(course.title).isEqualTo(title)
        assertThat(course.fee).isEqualTo(fee)
    }

}
