package kr.flab.outflearn.student.domain

import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.support.AbstractEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Enroll(

    @ManyToOne(fetch = FetchType.LAZY)
    var student: Student,

    @ManyToOne(fetch = FetchType.LAZY)
    var course: Course,

    @Enumerated(EnumType.STRING)
    var status: EnrollStatus,

    var registeredDateTime: LocalDateTime = LocalDateTime.now(),

    var paidDateDateTime: LocalDateTime? = null,

    id: Long? = null
) : AbstractEntity(id) {
}
