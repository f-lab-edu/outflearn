package kr.flab.outflearn.student.domain.repository

import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.student.domain.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface EnrollRepository : JpaRepository<Enroll, Long> {

    @Query("select e from Enroll e join fetch e.course c where e.student = :student")
    fun findByStudent(student: Student): List<Enroll>
}
