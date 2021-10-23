package kr.flab.outflearn.admin.service

import kr.flab.outflearn.admin.domain.TeacherApprovedEvent
import kr.flab.outflearn.admin.domain.repository.AdminRepository
import kr.flab.outflearn.member.domain.repository.MemberRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

interface AdminService {
    fun examineTeacherQualification(memberId: Long)
}

@Service
class DefaultAdminService(
    private val adminRepository: AdminRepository,
    private val memberRepository: MemberRepository,
    private val eventPublisher: ApplicationEventPublisher
) : AdminService {
    override fun examineTeacherQualification(memberId: Long) {
        val member = memberRepository.findById(memberId).get()

        // 성공했을 때
        eventPublisher.publishEvent(TeacherApprovedEvent(member))
    }



}
