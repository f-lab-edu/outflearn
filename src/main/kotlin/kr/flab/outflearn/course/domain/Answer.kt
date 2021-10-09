package kr.flab.outflearn.course.domain

import kr.flab.outflearn.teacher.domain.Teacher
import javax.persistence.*

@Entity
class Answer(

    var content: String,

    @OneToOne(fetch = FetchType.LAZY)
    var question: Question,

    @ManyToOne(fetch = FetchType.LAZY)
    var teacher: Teacher,

    @Id @GeneratedValue
    var id: Long? = null
) {
}
