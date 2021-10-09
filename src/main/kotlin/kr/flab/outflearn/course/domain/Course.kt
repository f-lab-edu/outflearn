package kr.flab.outflearn.course.domain

import kr.flab.outflearn.teacher.domain.Teacher
import javax.persistence.*

@Entity
class Course(

    var name: String,

    var fee: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var teacher: Teacher,

    @Id @GeneratedValue
    var id: Long? = null
) {
}
