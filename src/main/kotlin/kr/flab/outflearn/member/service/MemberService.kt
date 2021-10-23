package kr.flab.outflearn.member.service

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.MemberCreatedEvent
import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

interface MemberService {
    fun createMember(memberCreateDto: MemberCreateDto): Member

}

@Service
class DefaultMemberService(
    private val memberRepository: MemberRepository,
    private val eventPublisher: ApplicationEventPublisher
): MemberService {

    override fun createMember(memberCreateDto: MemberCreateDto): Member {
        var member = Member(memberCreateDto.name, memberCreateDto.email, memberCreateDto.password)
        member = memberRepository.save(member)

        eventPublisher.publishEvent(MemberCreatedEvent(member))

        return member
    }
}
