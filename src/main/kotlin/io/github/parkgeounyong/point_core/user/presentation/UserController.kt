package io.github.parkgeounyong.point_core.user.presentation

import io.github.parkgeounyong.point_core.user.application.UserService
import io.github.parkgeounyong.point_core.user.application.command.UserCreateCommand
import io.github.parkgeounyong.point_core.user.application.command.UserUpdateCommand
import io.github.parkgeounyong.point_core.user.domain.user.model.User
import io.github.parkgeounyong.point_core.user.presentation.request.UserCreateRequest
import io.github.parkgeounyong.point_core.user.presentation.request.UserUpdateRequest
import io.github.parkgeounyong.point_core.user.presentation.response.UserResponse
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/user")
    fun save(@RequestBody userCreateRequest: UserCreateRequest): UserResponse {
        return userService.save(
            UserCreateCommand(
                userId = userCreateRequest.userId,
                name = userCreateRequest.name,
                pw = userCreateRequest.pw,
                phone = userCreateRequest.phone
            )
        ).toResponse()
    }

    @PutMapping("/user/{userId}")
    fun update(@PathVariable userId: String, @RequestBody userUpdateRequest: UserUpdateRequest): UserResponse {
        return userService.update(
            UserUpdateCommand(
                userId = userId,
                name = userUpdateRequest.name,
                pw = userUpdateRequest.pw,
                phone = userUpdateRequest.phone
            )
        ).toResponse()
    }

    fun User.toResponse(): UserResponse =
        UserResponse(
            userId = userId,
            name = name,
            phone = phone,
        )
}