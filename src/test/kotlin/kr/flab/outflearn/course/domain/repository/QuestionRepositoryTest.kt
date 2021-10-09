package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Question
import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.student.domain.repository.StudentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class QuestionRepositoryTest {

    @Autowired
    lateinit var questionRepository: QuestionRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var studentRepository: StudentRepository


    @Test
    fun `강의 저장하기`() {
        // given
        val member = Member("member")
        val student = Student("student", member)

        memberRepository.save(member)
        studentRepository.save(student)

        val title = "질문"
        val content = "내용"
        val question = Question(title, content, student)
        assertThat(question.id).isNull()

        // when
        questionRepository.save(question)
        questionRepository.flush()

        // then
        assertThat(question.id).isNotNull
        assertThat(question.title).isEqualTo(title)
        assertThat(question.content).isEqualTo(content)
    }

}
