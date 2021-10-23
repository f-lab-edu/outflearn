package kr.flab.outflearn

import kr.flab.outflearn.course.domain.Answer
import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.Question
import kr.flab.outflearn.course.domain.Review
import kr.flab.outflearn.student.domain.Student
import kr.flab.outflearn.teacher.domain.Teacher

fun createCourse(
    title: String = "title",
    teacher: Teacher = createTeacher(),
    price: Int = 30000,
    id: Long = 1L
): Course {
    return Course(title = title, price = price, teacher = teacher, id = id)
}

fun createQuestion(
    title: String = "title",
    content: String = "content",
    student: Student = createStudent(),
    course: Course = createCourse(),
    id: Long = 1L
): Question {
    return Question(title = title, content = content, student = student, course = course, id = id)
}

fun createAnswer(
    content: String = "content",
    course: Course = createCourse(),
    question: Question = createQuestion(),
    id: Long = 1L
): Answer {
    return Answer(content, course, question, id)
}

fun createReview(
    content: String = "content",
    starRate: Int = 5,
    course: Course = createCourse(),
    student: Student = createStudent(),
    id: Long = 1L
): Review {
    return Review(content, starRate, course, student, id)
}
