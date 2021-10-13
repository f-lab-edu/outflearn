package kr.flab.outflearn

import kr.flab.outflearn.teacher.domain.Teacher

fun createTeacher(
    nickname: String = "teacher",
    id: Long = 1L
): Teacher {
    return Teacher(nickname, createMember(), id)
}

