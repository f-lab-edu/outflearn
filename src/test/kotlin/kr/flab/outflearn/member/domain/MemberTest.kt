package kr.flab.outflearn.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemberTest {

    @Test
    fun `회원 생성하기`() {
        // given
        val name = "flab"

        // when
        val member = Member(name)

        // then
        assertThat(member.id).isNull()
        assertThat(member.name).isEqualTo(name)
    }
}
