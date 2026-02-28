package io.github.parkgeounyong.point_core.user.presentation.request


data class UserCreateRequest(
    val userId: String,
    val pw: String,
    val name: String,
    val phone: String
)
