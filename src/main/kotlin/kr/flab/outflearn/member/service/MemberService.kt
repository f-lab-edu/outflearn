package kr.flab.outflearn.member.service

import kr.flab.outflearn.member.domain.Member

interface MemberService {
    fun createMember(memberCreateDto: MemberCreateDto): Member

}
