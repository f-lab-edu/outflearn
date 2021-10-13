package kr.flab.outflearn.student.domain.repository

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.student.domain.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class StudentRepositoryTest {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun `학생 저장하기`() {
        // given
        val member = Member("member")
        memberRepository.save(member)

        val studentName = "student"
        val student = Student(studentName, member)
        assertThat(student.id).isNull();

        // when
        studentRepository.save(student)
        studentRepository.flush()

        // then
        assertThat(student.id).isNotNull
        assertThat(student.nickname).isEqualTo(studentName)
    }
}
