package io.github.parkgeounyong.point_core.user.domain.user.model

import java.time.Instant

class User(
    val id: Long? = null,
    val userId: String,
    val pw: String,
    val name: String,
    val phone: String,
    val entDate: Instant,
    val updDate: Instant,
) {
    companion object {
        fun create(
            userId: String,
            name: String,
            pw: String,
            phone: String,
        ): User {
            return User(
                userId = userId,
                name = name,
                pw = pw,
                phone = phone,
                entDate = Instant.now(),
                updDate = Instant.now(),
            )
        }
    }
}