package kr.flab.outflearn.teacher.domain

import kr.flab.outflearn.member.domain.Member
import javax.persistence.*

@Entity
class Teacher(

    var name: String,

    @OneToOne
    var member: Member,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {

}
