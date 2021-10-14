package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.teacher.domain.Teacher
import kr.flab.outflearn.teacher.domain.repository.TeacherRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class CourseRepositoryTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var teacherRepository: TeacherRepository

    @Test
    fun `강의 저장하기`() {
        // given
        val member = Member("member")
        val teacher = Teacher("teacher", member)

        memberRepository.save(member)
        teacherRepository.save(teacher)

        val courseName = "멘토링"
        val fee = 3000
        val course = Course(courseName, fee, teacher)
        assertThat(course.id).isNull()

        // when
        courseRepository.save(course)
        courseRepository.flush()

        // then
        assertThat(course.id).isNotNull
        assertThat(course.title).isEqualTo(courseName)
        assertThat(course.fee).isEqualTo(fee)
    }

}
