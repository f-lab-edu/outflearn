package kr.flab.outflearn.course.domain

import kr.flab.outflearn.student.domain.Student
import javax.persistence.*

@Entity
class Question(

    var title: String,

    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var student: Student,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}
