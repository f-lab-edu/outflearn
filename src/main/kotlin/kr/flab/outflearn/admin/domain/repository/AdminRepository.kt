package kr.flab.outflearn.admin.domain.repository

import kr.flab.outflearn.admin.domain.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository : JpaRepository<Admin, Long> {
}
