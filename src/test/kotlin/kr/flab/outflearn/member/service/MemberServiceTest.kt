package kr.flab.outflearn.member.service

import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
internal class MemberServiceTest {
    @Autowired
    private lateinit var memberService: MemberService

    @Test
    fun `회원 가입`() {
        // given
        val name = "name"
        val password = "12345678"
        val email = "flab@mail.co.kr"
        val memberCreateDto = MemberCreateDto(email, password, name)

        // when
        val member = memberService.createMember(memberCreateDto)

        // then
        assertThat(member.id).isNotNull;
        assertThat(member.name).isEqualTo(name)
        assertThat(member.email).isEqualTo(email)
    }
}
