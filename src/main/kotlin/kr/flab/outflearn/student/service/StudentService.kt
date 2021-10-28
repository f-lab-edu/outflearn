package kr.flab.outflearn.student.service

import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.student.domain.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface StudentService {
    fun getOrCreateStudent(studentGetOrCreateDto: StudentGetOrCreateDto): Student
}

@Service
@Transactional
class DefaultStudentService(
    private val studentRepository: StudentRepository,
    private val memberRepository: MemberRepository
) : StudentService {
    override fun getOrCreateStudent(studentGetOrCreateDto: StudentGetOrCreateDto): Student {
        val member = memberRepository.getById(studentGetOrCreateDto.memberId)

        return studentRepository.findByMember(member) ?: run {
            val student = Student(member.name, member)
            studentRepository.save(student)
        }
    }
}
