package kr.flab.outflearn.course.domain

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.teacher.domain.Teacher
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CourseTest {

    @Test
    fun `강의 생성하기`() {
        // given
        val member = Member("member")
        val teacher = Teacher("teacher", member)

        // when
        val courseName = "멘토링"
        val coursePrice = 3000
        val course = Course(courseName, coursePrice, teacher)

        // then
        assertThat(course.id).isNull()
        assertThat(course.name).isEqualTo(courseName)
        assertThat(course.fee).isEqualTo(coursePrice)
    }
}
