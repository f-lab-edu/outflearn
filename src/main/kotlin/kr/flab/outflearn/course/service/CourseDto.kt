package kr.flab.outflearn.course.service

data class CourseCreateDto(
    var title: String,
    var teacherId: Long,
    var price: Int
)
