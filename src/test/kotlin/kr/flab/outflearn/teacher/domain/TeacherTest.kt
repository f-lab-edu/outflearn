package kr.flab.outflearn.teacher.domain

import kr.flab.outflearn.createMember
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TeacherTest {

    @Test
    fun `강사 생성하기`() {
        // given
        val nickname = "member"
        val member = createMember()

        // when
        val teacher = Teacher(nickname, member)

        // then
        assertThat(teacher.id).isNull()
        assertThat(teacher.member.name).isEqualTo(nickname)
    }
    
}
