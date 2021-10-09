package kr.flab.outflearn.course.domain

import kr.flab.outflearn.student.domain.Student
import javax.persistence.*

@Entity
class Review(
    var content: String,

    @ManyToOne
    var student: Student,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}
