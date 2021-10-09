package kr.flab.outflearn.member.domain.repository

import kr.flab.outflearn.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}
