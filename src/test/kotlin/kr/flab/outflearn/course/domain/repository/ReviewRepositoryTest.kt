package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.Review
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
internal class ReviewRepositoryTest {

    @Autowired
    lateinit var reviewRepository: ReviewRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Autowired
    lateinit var teacherRepository: TeacherRepository

    @Autowired
    lateinit var courseRepository: CourseRepository


    @Test
    fun `리뷰 저장하기`() {
        // given
        val member = Member("member")
        val student = Student("student", member)
        val teacher = Teacher("teacher", member)
        val course = Course("course", 30000, teacher)

        memberRepository.save(member)
        studentRepository.save(student)
        teacherRepository.save(teacher)
        courseRepository.save(course)

        val content = "내용"
        val review = Review(content, 5, course, student)
        assertThat(review.id).isNull()

        // when
        reviewRepository.save(review)
        reviewRepository.flush()

        // then
        assertThat(review.id).isNotNull
        assertThat(review.content).isEqualTo(content)
    }
}
