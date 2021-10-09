package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
}
