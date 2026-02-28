package io.github.parkgeounyong.point_core.user.presentation

import io.github.parkgeounyong.point_core.user.application.UserService
import io.github.parkgeounyong.point_core.user.domain.user.model.User
import io.github.parkgeounyong.point_core.user.infrastructure.mapper.UserApiMapper.toCommand
import io.github.parkgeounyong.point_core.user.presentation.request.UserCreateRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/user")
    fun save(@RequestBody userCreateRequest: UserCreateRequest): User {
        return userService.save(userCreateRequest.toCommand())
    }
}