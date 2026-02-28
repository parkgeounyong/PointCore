package io.github.parkgeounyong.point_core.user.application.command


data class UserUpdateCommand(
    val userId: String,
    val pw: String,
    val name: String,
    val phone: String
)
