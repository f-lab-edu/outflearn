package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Answer
import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.Question
import kr.flab.outflearn.createMember
import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.student.domain.repository.StudentRepository
import kr.flab.outflearn.teacher.domain.Teacher
import kr.flab.outflearn.teacher.domain.repository.TeacherRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class AnswerRepositoryTest {

    @Autowired
    lateinit var answerRepository: AnswerRepository

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Autowired
    lateinit var questionRepository: QuestionRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var teacherRepository: TeacherRepository

    @Autowired
    lateinit var studentRepository: StudentRepository


    @Test
    fun `답변 저장하기`() {
        // given
        val member = createMember()
        val student = Student("student", member)
        val teacher = Teacher("teacher", member)
        val course = Course(title = "title", fee = 3000, teacher = teacher)
        val question = Question("질문", "내용", student, course)

        memberRepository.save(member)
        studentRepository.save(student)
        teacherRepository.save(teacher)
        courseRepository.save(course)
        questionRepository.save(question)

        val content = "content"
        val answer = Answer(content = content, course = course, question = question)

        // when
        answerRepository.save(answer)
        answerRepository.flush()

        // then
        assertThat(answer.id).isNotNull
        assertThat(answer.content).isEqualTo(content)
    }

}
