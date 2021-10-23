package kr.flab.outflearn.admin.service

import kr.flab.outflearn.admin.domain.TeacherApprovedEvent
import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.RecordApplicationEvents

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RecordApplicationEvents
internal class AdminServiceTest {

    @Autowired
    lateinit var adminService: AdminService

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var applicationEvents: ApplicationEvents

    @Test
    fun `강사 자격 승인 시 이벤트 발행`() {
        // given
        var member = Member("flab", "flab@email.com", "12345678")
        member = memberRepository.save(member)

        // when
        adminService.examineTeacherQualification(member.id!!)
        val count = applicationEvents.stream(TeacherApprovedEvent::class.java).count();

        // then
        assertThat(1).isEqualTo(count);
    }


}
