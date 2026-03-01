package io.github.parkgeounyong.point_core.point.presentation

import io.github.parkgeounyong.point_core.point.application.PointService
import io.github.parkgeounyong.point_core.point.application.command.PointCommand
import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
import io.github.parkgeounyong.point_core.point.presentation.request.PointRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PointController(
    private val pointService: PointService,
) {
    @PostMapping("/point/{pointTransactionType}")
    fun pointProcess(
        @PathVariable pointTransactionType: PointTransactionType,
        @RequestBody pointRequest: PointRequest
    ) {
        return pointService.pointProcess(
            PointCommand(
                userSeq = pointRequest.userSeq,
                pointAccountType = pointRequest.pointAccountType,
                pointTransactionType = pointTransactionType,
                externalTxId = pointRequest.externalTxId,
                amount = pointRequest.amount,
                originalTransactionId = pointRequest.originalTransactionId,
            )
        )
    }
}