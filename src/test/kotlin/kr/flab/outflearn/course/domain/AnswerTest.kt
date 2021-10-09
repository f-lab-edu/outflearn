package kr.flab.outflearn.course.domain

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.teacher.domain.Teacher
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnswerTest {


    @Test
    fun `답변 남기기`() {
        // given
        val member = Member("member")
        val student = Student("student", member)
        val teacher = Teacher("teacher", member)
        val question = Question("title", "content", student)

        // when
        val content = "content"
        val answer = Answer(question = question, content = content, teacher = teacher)

        // then
        assertThat(answer.id).isNull();
        assertThat(answer.content).isEqualTo(content);
    }
}
