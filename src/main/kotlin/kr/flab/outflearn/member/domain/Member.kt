package kr.flab.outflearn.member.domain

import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.Entity

@Entity
class Member(
    var name: String,

    var email: String,

    var password: String,

    id: Long? = null
) : AbstractEntity(id) {
}
