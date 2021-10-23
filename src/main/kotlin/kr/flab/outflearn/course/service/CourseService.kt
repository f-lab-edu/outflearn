package kr.flab.outflearn.course.service

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.CourseCreatedEvent
import kr.flab.outflearn.course.domain.repository.CourseRepository
import kr.flab.outflearn.teacher.domain.repository.TeacherRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface CourseService {
    fun createCourse(createDto: CourseCreateDto): Course
}


@Service
@Transactional
class DefaultCourseService(
    private val courseRepository: CourseRepository,
    private val teacherRepository: TeacherRepository,
    private val eventPublisher: ApplicationEventPublisher
) : CourseService {
    override fun createCourse(createDto: CourseCreateDto): Course {
        val teacher = teacherRepository.findById(createDto.teacherId).get()

        var course = Course(createDto.title, createDto.price, teacher)

        course = courseRepository.save(course)

        eventPublisher.publishEvent(CourseCreatedEvent(course))

        return course
    }


}
