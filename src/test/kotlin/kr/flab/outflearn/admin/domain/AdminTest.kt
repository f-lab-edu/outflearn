package kr.flab.outflearn.admin.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminTest {

    @Test
    fun `어드민 생성하기`() {
        // given
        val email = "flab-admin@email.com"
        val password = "12345678"
        val name = "admin"

        // when
        val admin = Admin(email, password, name)

        // then
        assertThat(admin.id).isNull()
        assertThat(admin.email).isEqualTo(email)
        assertThat(admin.password).isEqualTo(password)
        assertThat(admin.name).isEqualTo(name)
    }
}
