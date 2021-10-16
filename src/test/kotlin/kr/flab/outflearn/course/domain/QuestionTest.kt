package kr.flab.outflearn.course.domain

import kr.flab.outflearn.createCourse
import kr.flab.outflearn.createMember
import kr.flab.outflearn.createStudent
import kr.flab.outflearn.createTeacher
import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.student.domain.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QuestionTest {

    @Test
    fun `질문하기`() {
        // given
        val student = createStudent()
        val course = createCourse("student", createTeacher())

        // when
        val title = "질문"
        val content = "내용"
        val question = Question(title, content, createStudent(), createCourse())

        // then
        assertThat(question.title).isEqualTo(title);
        assertThat(question.content).isEqualTo(content);
    }
}
