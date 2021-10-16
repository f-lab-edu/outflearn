package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long> {
    fun findByCourse(course: Course): List<Question>
}
