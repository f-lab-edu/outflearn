package kr.flab.outflearn.member.service

import kr.flab.outflearn.member.domain.MemberCreatedEvent
import kr.flab.outflearn.student.domain.EnrollRegisteredEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.RecordApplicationEvents

@RecordApplicationEvents
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
internal class MemberServiceTest {
    @Autowired
    private lateinit var memberService: MemberService

    @Autowired
    lateinit var applicationEvents: ApplicationEvents

    @Test
    fun `회원 가입 이벤트 발행`() {
        // given
        val name = "name"
        val password = "12345678"
        val email = "flab@mail.co.kr"
        val memberCreateDto = MemberCreateDto(email, password, name)

        // when
        val member = memberService.createMember(memberCreateDto)
        val count = applicationEvents.stream(MemberCreatedEvent::class.java).count()

        // then
        assertThat(member.id).isNotNull;
        assertThat(member.name).isEqualTo(name)
        assertThat(member.email).isEqualTo(email)
        assertThat(count).isEqualTo(1)
    }

}
