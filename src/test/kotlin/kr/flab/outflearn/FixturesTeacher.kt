package kr.flab.outflearn

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.teacher.domain.Teacher

fun createTeacher(
    nickname: String = "teacher",
    member: Member = createMember(),
    id: Long = 1L
): Teacher {
    return Teacher(nickname, member, id)
}

