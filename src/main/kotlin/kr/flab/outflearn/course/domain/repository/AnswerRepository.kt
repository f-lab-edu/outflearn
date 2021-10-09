package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long> {
}
