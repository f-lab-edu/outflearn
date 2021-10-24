package kr.flab.outflearn.student.service

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.student.domain.repository.StudentRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
internal class StudentServiceTest {

    @Autowired
    lateinit var studentService: StudentService

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Autowired
    lateinit var memberRepository: MemberRepository
    
    @Test
    fun `수강생 조회하기 - 기존에 데이터 없을 시`() {
        // given
        var member = Member("flab", "flab@email.com", "12345678")
        member = memberRepository.save(member)
        val studentCreateDto = StudentGetOrCreateDto(member.id!!)

        // when
        val student = studentService.getOrCreateStudent(studentCreateDto)

        // then
        assertThat(student.id).isNotNull
        assertThat(student.nickname).isEqualTo(member.name)
    }

    @Test
    fun `수강생 조회하기 - 기존에 데이터 있을 시`() {
        // given
        var member = Member("flab", "flab@email.com", "12345678")
        member = memberRepository.save(member)

        val beforeStudent = Student("flab", member)
        studentRepository.save(beforeStudent)

        val studentCreateDto = StudentGetOrCreateDto(member.id!!)

        // when
        val student = studentService.getOrCreateStudent(studentCreateDto)

        // then
        assertThat(student.id).isEqualTo(beforeStudent.id)
    }
}
