package kr.flab.outflearn.member.service

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class DefaultMemberService(
    private val memberRepository: MemberRepository
): MemberService {

    override fun createMember(memberCreateDto: MemberCreateDto): Member {
        val member = Member(memberCreateDto.name, memberCreateDto.email, memberCreateDto.password)
        return memberRepository.save(member)
    }
}
