package io.github.parkgeounyong.point_core.user.application.mapper

import io.github.parkgeounyong.point_core.user.application.command.UserCreateCommand
import io.github.parkgeounyong.point_core.user.domain.user.model.User

object UserApplicationMapper {
    fun UserCreateCommand.toDomain(): User {
        return User.create(
            userId = this.userId,
            name = this.name,
            pw = this.pw,
            phone = this.phone,
        )
    }
}