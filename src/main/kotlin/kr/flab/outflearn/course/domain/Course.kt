package kr.flab.outflearn.course.domain

import kr.flab.outflearn.student.domain.Enroll
import kr.flab.outflearn.support.AbstractEntity
import kr.flab.outflearn.teacher.domain.Teacher
import javax.persistence.*

@Entity
class Course(
    var title: String,

    var fee: Int,

    @OneToMany(mappedBy = "course")
    var enrolls: MutableList<Enroll> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    var teacher: Teacher,

    id: Long? = null
) : AbstractEntity(id) {
}
