package kr.flab.outflearn.course.domain

import kr.flab.outflearn.createCourse
import kr.flab.outflearn.createQuestion
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnswerTest {


    @Test
    fun `답변 남기기`() {
        // given
        val content = "content"

        // when
        val answer = Answer(content, createCourse(), createQuestion())

        // then
        assertThat(answer.id).isNull();
        assertThat(answer.content).isEqualTo(content);
    }
}
