package kr.flab.outflearn

import kr.flab.outflearn.member.domain.Member

fun createMember(
    name: String = "name",
    email: String = "flab@email.co.kr",
    password: String = "12345678",
    id: Long = 1L
): Member {
    return Member(name = name, email = email, password = password, id = id)
}




