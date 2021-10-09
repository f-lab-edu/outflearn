package kr.flab.outflearn.teacher.domain.repository

import kr.flab.outflearn.teacher.domain.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository : JpaRepository<Teacher, Long> {
}
