package kr.flab.outflearn.course.domain

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.student.domain.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReviewTest {

    @Test
    fun `리뷰 생성`() {
        // given
        val member = Member("name")
        val student = Student("student", member)

        // when
        val content = "content"
        val review = Review(content, student)

        // then
        assertThat(review.id).isNull();
        assertThat(review.content).isEqualTo(content)
    }
}
