package kr.flab.outflearn.teacher.domain.repository

import kr.flab.outflearn.member.domain.Member
import kr.flab.outflearn.member.domain.repository.MemberRepository
import kr.flab.outflearn.teacher.domain.Teacher
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class TeacherRepositoryTest {

    @Autowired
    lateinit var teacherRepository: TeacherRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun `강사 저장하기`() {
        // given
        val member = Member("member")
        memberRepository.save(member)
        val name = "teacher"
        val teacher = Teacher(name, member)

        assertThat(teacher.id).isNull()

        // when
        teacherRepository.save(teacher)
        teacherRepository.flush()

        // then
        assertThat(teacher.id).isNotNull
        assertThat(teacher.name).isEqualTo(name)
    }
}

