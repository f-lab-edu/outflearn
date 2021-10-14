package kr.flab.outflearn.course.domain

import kr.flab.outflearn.support.AbstractEntity
import kr.flab.outflearn.teacher.domain.Teacher
import javax.persistence.*

@Entity
class Course(
    var title: String,

    var fee: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var teacher: Teacher,

    id: Long? = null
) : AbstractEntity(id) {
}
