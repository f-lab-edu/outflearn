package kr.flab.outflearn.admin.service

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kr.flab.outflearn.admin.domain.TeacherApprovedEvent
import kr.flab.outflearn.admin.domain.repository.AdminRepository
import kr.flab.outflearn.createMember
import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationEventPublisher
import org.springframework.test.context.event.RecordApplicationEvents
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(MockKExtension::class)
internal class AdminServiceMockTest {
    @MockK
    lateinit var adminRepository: AdminRepository

    @MockK
    lateinit var memberRepository: MemberRepository

    @MockK
    lateinit var eventPublisher: ApplicationEventPublisher

    lateinit var adminService: AdminService

    @Captor
    lateinit var eventArgumentCaptor: ArgumentCaptor<TeacherApprovedEvent>

    @BeforeEach
    fun setUp() {
        adminService = DefaultAdminService(adminRepository, memberRepository, eventPublisher)
    }


    @Disabled("MockK 버그 - https://stackoverflow.com/questions/64556991/mockk-causing-a-stackoverflowexception")
    @Test
    fun `강사 자격 승인 시 이벤트 발행`() {
        // given
        every {memberRepository.findById(1L)} returns Optional.of(createMember(id = 1L))

        // when
        adminService.examineTeacherQualification(1L)
        Mockito.verify(eventPublisher).publishEvent(eventArgumentCaptor.capture())

        // then
        Assertions.assertThat(createMember(id = 1L)).isEqualTo(eventArgumentCaptor.value);
    }

}
