package io.github.parkgeounyong.point_core.user.application

import io.github.parkgeounyong.point_core.user.application.command.UserCreateCommand
import io.github.parkgeounyong.point_core.user.application.command.UserUpdateCommand
import io.github.parkgeounyong.point_core.user.domain.user.model.User
import io.github.parkgeounyong.point_core.user.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun save(userCreateCommand: UserCreateCommand): User {
        return userRepository.save(
            User.create(
                userId = userCreateCommand.userId,
                name = userCreateCommand.name,
                pw = userCreateCommand.pw,
                phone = userCreateCommand.phone,
            )
        )
    }

    fun update(userUpdateCommand: UserUpdateCommand): User {
        val result = userRepository.findByUserId(userUpdateCommand.userId) ?: User.create(userUpdateCommand.userId, userUpdateCommand.name, userUpdateCommand.pw, userUpdateCommand.phone)
        result.update(
            pw = userUpdateCommand.pw,
            name = userUpdateCommand.name,
            phone = userUpdateCommand.phone
        )
        return userRepository.save(result)
    }
}