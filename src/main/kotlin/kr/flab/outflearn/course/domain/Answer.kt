package kr.flab.outflearn.course.domain

import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToOne

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
