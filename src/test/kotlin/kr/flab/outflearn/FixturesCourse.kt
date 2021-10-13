package kr.flab.outflearn

import kr.flab.outflearn.course.domain.Answer
import kr.flab.outflearn.course.domain.Course
import kr.flab.outflearn.course.domain.Question
import kr.flab.outflearn.course.domain.Review

fun createCourse(
    title: String = "title",
    id: Long = 1L
): Course {
    return Course(title, 30000, createTeacher(), id)
}

fun createQuestion(
    title: String = "title",
    content: String = "content",
    id: Long = 1L
): Question {
    return Question(title, content, createStudent(), id)
}

fun createAnswer(
    content: String = "content",
    id: Long = 1L
): Answer {
    return Answer(content, createCourse(), createQuestion(), id)
}

fun createReview(
    content: String = "content",
    starRate: Int = 5,
    id: Long = 1L
): Review {
    return Review(content, starRate, createCourse(), createStudent(), id)
}
