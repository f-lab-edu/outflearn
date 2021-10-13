package kr.flab.outflearn

import kr.flab.outflearn.member.domain.Member

fun createMember(
    name: String = "name",
    id: Long = 1L
): Member {
    return Member(name, id)
}




