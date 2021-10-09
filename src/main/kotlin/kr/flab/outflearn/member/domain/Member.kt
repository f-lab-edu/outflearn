package kr.flab.outflearn.member.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member (

    var name: String,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
){
    override fun toString(): String {
        return "Member(name='$name', id=$id)"
    }
}
