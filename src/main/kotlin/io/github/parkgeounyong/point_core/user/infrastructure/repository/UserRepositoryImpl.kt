package io.github.parkgeounyong.point_core.user.infrastructure.repository

import io.github.parkgeounyong.point_core.user.domain.user.model.User
import io.github.parkgeounyong.point_core.user.domain.user.repository.UserRepository
import io.github.parkgeounyong.point_core.user.infrastructure.mapper.UserEntityMapper.toDomain
import io.github.parkgeounyong.point_core.user.infrastructure.mapper.UserEntityMapper.toEntity
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun save(user: User): User {
        return userJpaRepository
            .save(user.toEntity())
            .toDomain()
    }
}