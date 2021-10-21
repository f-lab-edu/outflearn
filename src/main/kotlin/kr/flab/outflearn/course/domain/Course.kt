package kr.flab.outflearn.course.domain

import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.support.AbstractEntity
import kr.flab.outflearn.teacher.domain.Teacher
import javax.persistence.*

@Entity
class Course(
    var title: String,

    var price: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var teacher: Teacher,

    @OneToMany(mappedBy = "course")
    var enrolls: MutableList<Enroll> = mutableListOf(),

    id: Long? = null
) : AbstractEntity(id) {
}
