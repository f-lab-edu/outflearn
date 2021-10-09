package kr.flab.outflearn.student.domain

import kr.flab.outflearn.member.domain.Member
import javax.persistence.*

@Entity
class Student(
    var name: String,

    @OneToOne
    var member: Member,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}
