package kr.flab.outflearn.student.service

import kr.flab.outflearn.course.domain.repository.CourseRepository
import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.student.domain.EnrollRegisteredEvent
import kr.flab.outflearn.student.domain.repository.EnrollRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface EnrollService {
    fun registerEnroll(enrollRegisterDto: EnrollRegisterDto): Enroll
}

@Service
@Transactional
class DefaultEnrollService(
    private val enrollRepository: EnrollRepository,
    private val courseRepository: CourseRepository,
    private val studentService: StudentService,
    private val eventPublisher: ApplicationEventPublisher
) : EnrollService {
    override fun registerEnroll(enrollRegisterDto: EnrollRegisterDto): Enroll {
        val studentCreateDto = StudentGetOrCreateDto(enrollRegisterDto.memberId)
        val student = studentService.getOrCreateStudent(studentCreateDto)

        val course = courseRepository.findById(enrollRegisterDto.courseId).get()

        var enroll = Enroll(student, course)

        enroll =  enrollRepository.save(enroll)

        eventPublisher.publishEvent(EnrollRegisteredEvent(enroll))

        return enroll
    }

}
