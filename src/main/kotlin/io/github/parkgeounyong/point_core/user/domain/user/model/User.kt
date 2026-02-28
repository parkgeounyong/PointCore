package io.github.parkgeounyong.point_core.user.domain.user.model

import java.time.Instant

class User(
    val id: Long? = null,
    val userId: String,
    val entDate: Instant,
    pw: String,
    name: String,
    phone: String,
    updDate: Instant,
) {
    var pw: String = pw
        private set

    var name: String = name
        private set

    var phone: String = phone
        private set

    var updDate: Instant = updDate
        private set

    fun update(pw: String, name: String, phone: String) {
        require(name.isNotBlank())
        require(phone.isNotBlank())

        this.pw = pw
        this.name = name
        this.phone = phone
        this.updDate = updDate
    }

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