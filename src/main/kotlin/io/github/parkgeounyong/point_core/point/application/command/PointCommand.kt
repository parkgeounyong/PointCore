package io.github.parkgeounyong.point_core.point.application.command

import io.github.parkgeounyong.point_core.point.domain.model.enums.PointAccountType
import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
import java.math.BigDecimal

data class PointCommand(
    val userSeq: Long,
    val pointAccountType: PointAccountType,
    val pointTransactionType: PointTransactionType,
    val externalTxId: String,
    val amount: BigDecimal,
    val originalTransactionId: Long? = null,
)