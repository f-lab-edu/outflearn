package kr.flab.outflearn.student.domain

import kr.flab.outflearn.course.domain.Course
import javax.persistence.*

@Entity
class Enroll(

    @ManyToOne(fetch = FetchType.LAZY)
    var student: Student,

    @ManyToOne(fetch = FetchType.LAZY)
    var course: Course,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}
