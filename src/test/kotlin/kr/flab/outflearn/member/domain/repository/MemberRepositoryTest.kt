package kr.flab.outflearn.member.domain.repository

import kr.flab.outflearn.member.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository;

    @Test
    fun `회원 저장하기`() {
        // given
        val name = "flab"
        val email = "flab@email.co.kr"
        val password = "12345678"
        val member = Member(name, email, password)
        assertThat(member.id).isNull()

        // when
        memberRepository.save(member)
        memberRepository.flush()

        // then
        assertThat(member.id).isNotNull
        assertThat(member.name).isEqualTo(name)
    }

}
