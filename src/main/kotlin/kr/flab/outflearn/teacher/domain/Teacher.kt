package kr.flab.outflearn.teacher.domain

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToOne

@Entity
class Teacher(
    var nickname: String,

    @OneToOne(fetch = FetchType.LAZY)
    var member: Member,

    id: Long? = null
) : AbstractEntity(id) {
}
