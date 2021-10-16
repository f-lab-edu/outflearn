package kr.flab.outflearn.course.domain.repository

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.student.domain.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CourseRepository : JpaRepository<Course, Long> {
}
