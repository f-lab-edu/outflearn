package kr.flab.outflearn.student.domain.repository

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.student.domain.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByMember(member: Member): Student?
}
