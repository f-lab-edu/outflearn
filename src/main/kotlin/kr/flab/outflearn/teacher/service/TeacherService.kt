package kr.flab.outflearn.teacher.service

import kr.flab.outflearn.admin.domain.TeacherApprovedEvent
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.teacher.domain.Teacher
import kr.flab.outflearn.teacher.domain.repository.TeacherRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


interface TeacherService {
}

@Service
@Transactional
class DefaultTeacherService(
    private val teacherRepository: TeacherRepository,
    private val memberRepository: MemberRepository
) {

    @EventListener(TeacherApprovedEvent::class)
    fun onTeacherApproved(event: TeacherApprovedEvent) {
        val member = event.member
        val teacher = Teacher(member.name, member)

        teacherRepository.save(teacher)
    }
}
