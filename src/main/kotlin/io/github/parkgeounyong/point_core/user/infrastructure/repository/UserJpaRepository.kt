package io.github.parkgeounyong.point_core.user.infrastructure.repository

import io.github.parkgeounyong.point_core.user.infrastructure.entity.DataUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<DataUser, Long> {
    fun findByUserId(userId: String): DataUser
}