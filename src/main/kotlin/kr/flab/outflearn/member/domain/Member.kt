package kr.flab.outflearn.member.domain

import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    var name: String,

    id: Long? = null
) : AbstractEntity(id) {
}
