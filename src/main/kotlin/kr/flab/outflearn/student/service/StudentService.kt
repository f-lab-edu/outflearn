package kr.flab.outflearn.student.service

import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.student.domain.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface StudentService {
    fun createStudent(studentCreateDto: StudentCreateDto): Student
}

@Service
@Transactional
class DefaultStudentService(
    private val studentRepository: StudentRepository,
    private val memberRepository: MemberRepository
) : StudentService{
    override fun createStudent(studentCreateDto: StudentCreateDto): Student {
        val member = memberRepository.findById(studentCreateDto.memberId).get()

        val student = Student(member.name, member)
        return studentRepository.save(student)
    }
}
