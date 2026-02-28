package io.github.parkgeounyong.point_core.user.presentation.request


data class UserUpdateRequest(
    val pw: String,
    val name: String,
    val phone: String
)
