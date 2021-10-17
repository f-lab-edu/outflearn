package kr.flab.outflearn.course.domain

import kr.flab.outflearn.createMember
import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.teacher.domain.Teacher
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CourseTest {

    @Test
    fun `강의 생성하기`() {
        // given
        val member = createMember()
        val teacher = Teacher("teacher", member)

        // when
        val title = "멘토링"
        val fee = 3000
        val course = Course(title = title, fee = fee, teacher = teacher)

        // then
        assertThat(course.id).isNull()
        assertThat(course.title).isEqualTo(title)
        assertThat(course.fee).isEqualTo(fee)
    }
}
