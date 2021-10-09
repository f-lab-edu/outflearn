package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
}
