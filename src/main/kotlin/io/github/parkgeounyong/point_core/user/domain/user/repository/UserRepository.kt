package io.github.parkgeounyong.point_core.user.domain.user.repository

import io.github.parkgeounyong.point_core.user.domain.user.model.User

interface UserRepository {
    fun save(user: User): User
    fun findByUserId(userId: String): User?
}