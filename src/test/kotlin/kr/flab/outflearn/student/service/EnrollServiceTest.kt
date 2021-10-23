package kr.flab.outflearn.student.service

import kr.flab.outflearn.student.domain.EnrollRegisteredEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.RecordApplicationEvents
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@Sql("classpath:data/data.sql")
@Transactional
@RecordApplicationEvents
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
internal class EnrollServiceTest {
    @Autowired
    lateinit var enrollService: EnrollService

    @Autowired
    lateinit var applicationEvents: ApplicationEvents

    @Test
    fun `강의신청 시 이벤트 발행`() {
        // given
        val dto = EnrollRegisterDto(101L, 101L)

        // when
        val enroll = enrollService.registerEnroll(dto)
        val count = applicationEvents.stream(EnrollRegisteredEvent::class.java).count()

        // then
        assertThat(enroll.id).isNotNull
        assertThat(count).isEqualTo(1)
    }

}
