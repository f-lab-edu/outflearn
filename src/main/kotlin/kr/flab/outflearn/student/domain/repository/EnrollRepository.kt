package kr.flab.outflearn.student.domain.repository

import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.student.domain.Student
import org.springframework.data.jpa.repository.JpaRepository

interface EnrollRepository : JpaRepository<Enroll, Long> {
    fun findByStudent(student: Student): List<Enroll>
}
