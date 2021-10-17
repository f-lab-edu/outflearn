package kr.flab.outflearn.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemberTest {

    @Test
    fun `회원 생성하기`() {
        // given
        val name = "flab"
        val email = "flab@email.co.kr"
        val password = "12345678"

        // when
        val member = Member(name, email, password)

        // then
        assertThat(member.id).isNull()
        assertThat(member.name).isEqualTo(name)
    }
}
