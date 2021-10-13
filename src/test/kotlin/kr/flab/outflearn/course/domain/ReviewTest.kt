package kr.flab.outflearn.course.domain

import kr.flab.outflearn.createCourse
import kr.flab.outflearn.createStudent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReviewTest {

    @Test
    fun `리뷰 생성`() {
        // given
        val content = "content"

        // when
        val review = Review(content, 5, createCourse(), createStudent())

        // then
        assertThat(review.id).isNull();
        assertThat(review.content).isEqualTo(content)
    }
}
