package io.github.parkgeounyong.point_core.user.application.command


data class UserCreateCommand(
    val userId: String,
    val pw: String,
    val name: String,
    val phone: String
)
