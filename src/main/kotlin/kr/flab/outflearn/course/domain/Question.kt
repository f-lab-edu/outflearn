package kr.flab.outflearn.course.domain

import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.*

@Entity
class Question(
    var title: String,

    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var student: Student,

    id: Long? = null
) : AbstractEntity(id) {
}
