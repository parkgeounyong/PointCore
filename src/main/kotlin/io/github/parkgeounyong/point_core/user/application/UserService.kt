package io.github.parkgeounyong.point_core.user.application

import io.github.parkgeounyong.point_core.user.application.command.UserCreateCommand
import io.github.parkgeounyong.point_core.user.application.mapper.UserApplicationMapper.toDomain
import io.github.parkgeounyong.point_core.user.domain.user.model.User
import io.github.parkgeounyong.point_core.user.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun save(userCreateCommand: UserCreateCommand): User {
        return userRepository.save(userCreateCommand.toDomain())
    }
}