package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.Question
import kr.flab.outflearn.createCourse
import kr.flab.outflearn.createStudent
import kr.flab.outflearn.createTeacher
import kr.flab.outflearn.student.domain.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql

@Sql("classpath:data/data.sql")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class QuestionRepositoryTest {

    @Autowired
    lateinit var questionRepository: QuestionRepository

    lateinit var student: Student

    lateinit var course: Course

    @BeforeEach
    fun setUp() {
        student = createStudent(id = 101)
        course = createCourse(teacher = createTeacher(id = 201), id = 101)
    }

    @Test
    fun `질문 저장하기`() {
        // given
        val title = "질문"
        val content = "내용"
        val question = Question(title, content, student, course)
        assertThat(question.id).isNull()

        // when
        questionRepository.save(question)
        questionRepository.flush()

        // then
        assertThat(question.id).isNotNull
        assertThat(question.title).isEqualTo(title)
        assertThat(question.content).isEqualTo(content)
    }

    @Test
    fun `강의 질문 리스트 가져오기`() {
        // given
        val question1 = Question("질문1", "내용1", student, course)
        val question2 = Question("질문2", "내용2", student, course)
        questionRepository.saveAll(listOf(question1, question2))

        // when
        val courses = questionRepository.findByCourse(course)

        // then
        assertThat(courses).hasSize(2)
    }

}
