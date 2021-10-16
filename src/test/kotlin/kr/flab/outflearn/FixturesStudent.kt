package kr.flab.outflearn

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.student.domain.EnrollStatus
import kr.flab.outflearn.student.domain.Student

fun createStudent(
    nickname: String = "name",
    member: Member = createMember(),
    id: Long = 1L
): Student {
    return Student(nickname, member, id)
}

fun createEnroll(
    enrollStudent: EnrollStatus = EnrollStatus.REGISTERED,
    id: Long = 1L
): Enroll {
    return Enroll(createStudent(), createCourse(), enrollStudent, id = id)
}
