package io.github.parkgeounyong.point_core.user.infrastructure.mapper

import io.github.parkgeounyong.point_core.user.application.command.UserCreateCommand
import io.github.parkgeounyong.point_core.user.presentation.request.UserCreateRequest

object UserApiMapper {
    fun UserCreateRequest.toCommand(): UserCreateCommand {
        return UserCreateCommand(
            userId = this.userId,
            name = this.name,
            pw = this.pw,
            phone = this.phone
        )
    }
}