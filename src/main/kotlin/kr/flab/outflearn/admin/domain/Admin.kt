package kr.flab.outflearn.admin.domain

import kr.flab.outflearn.support.AbstractEntity
import javax.persistence.Entity

@Entity
class Admin(

    var email: String,

    var password: String,

    var name: String,

    var role: AdminRole = AdminRole.ADMIN,

    id: Long? = null
) : AbstractEntity(id) {
}
