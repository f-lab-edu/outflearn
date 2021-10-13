package kr.flab.outflearn.student.domain

import kr.flab.outflearn.member.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StudentTest {

    @Test
    fun `학생 생성하기`() {
        // given
        val member = Member("name")

        // when
        val name = "student"
        val student = Student(name, member)

        // then
        assertThat(student.id).isNull()
        assertThat(student.nickname).isEqualTo(name)
    }
}
