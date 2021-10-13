package kr.flab.outflearn.course.domain

import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.*

@Entity
class Review(
    var content: String,

    @Column(length = 5)
    var starRate: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var course: Course,

    @ManyToOne(fetch = FetchType.LAZY)
    var student: Student,

    id: Long? = null
) : AbstractEntity(id) {
}
