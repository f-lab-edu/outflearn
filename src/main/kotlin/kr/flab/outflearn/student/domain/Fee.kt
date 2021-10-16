package kr.flab.outflearn.student.domain

import kr.flab.outflearn.support.AbstractEntity

class Fee(
    price: Int,

    id: Long? = null
) : AbstractEntity(id) {
}
