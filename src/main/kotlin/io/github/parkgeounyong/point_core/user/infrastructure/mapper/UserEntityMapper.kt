package io.github.parkgeounyong.point_core.user.infrastructure.mapper

import io.github.parkgeounyong.point_core.user.domain.user.model.User
import io.github.parkgeounyong.point_core.user.infrastructure.entity.DataUser

object UserEntityMapper {
    fun User.toEntity(): DataUser {
        return DataUser(
            id = this.id,
            userId = this.userId,
            name = this.name,
            pw = this.pw,
            phone = this.phone,
            entDate = this.entDate,
            updDate = this.updDate,
        )
    }

    fun DataUser.toDomain(): User {
        return User(
            id = this.id,
            userId = this.userId,
            name = this.name,
            pw = this.pw,
            phone = this.phone,
            entDate = this.entDate,
            updDate = this.updDate,
        )
    }
}