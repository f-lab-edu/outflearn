package kr.flab.outflearn.student.service

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
internal class StudentServiceTest {

    @Autowired
    lateinit var studentService: StudentService

    @Autowired
    lateinit var memberRepository: MemberRepository
    
    @Test
    fun `수강생 생성하기`() {
        // given
        var member = Member("flab", "flab@email.com", "12345678")
        member = memberRepository.save(member)
        val studentCreateDto = StudentCreateDto(member.id!!)

        // when
        val student = studentService.createStudent(studentCreateDto)

        // then
        assertThat(student.id).isNotNull
        assertThat(student.nickname).isEqualTo(member.name)
    }
}
