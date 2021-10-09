package kr.flab.outflearn.course.domain

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.student.domain.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QuestionTest {

    @Test
    fun `질문하기`() {
        // given
        val member = Member("member")
        val student = Student("student", member)

        // when
        val title = "질문"
        val content = "내용"
        val question = Question(title, content, student)

        // then
        assertThat(question.title).isEqualTo(title);
        assertThat(question.content).isEqualTo(content);
    }
}
