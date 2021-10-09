package kr.flab.outflearn.teacher.domain

import kr.flab.outflearn.member.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TeacherTest {

    @Test
    fun `강사 생성하기`() {
        // given
        val name = "member"
        val member = Member(name)

        // when
        val teacher = Teacher(name, member)

        // then
        assertThat(teacher.id).isNull()
        assertThat(teacher.member.name).isEqualTo(name)
    }
    
}
