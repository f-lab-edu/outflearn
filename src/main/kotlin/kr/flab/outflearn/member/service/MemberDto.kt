package kr.flab.outflearn.member.service

data class MemberCreateDto(
    var email: String,
    var password: String,
    var name: String
)

data class MemberLoginDto(
    var email: String,
    var password: String
)
