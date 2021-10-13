package kr.flab.outflearn.course.domain

import kr.flab.outflearn.support.AbstractEntity
import kr.flab.outflearn.teacher.domain.Teacher
import javax.persistence.*

@Entity
class Answer(

    var content: String,

    @OneToOne(fetch = FetchType.LAZY)
    var course: Course,

    @OneToOne(fetch = FetchType.LAZY)
    var question: Question,

    id: Long? = null
) : AbstractEntity(id) {
}
