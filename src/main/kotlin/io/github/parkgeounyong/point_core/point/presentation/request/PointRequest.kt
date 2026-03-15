package io.github.parkgeounyong.point_core.point.presentation.request

import io.github.parkgeounyong.point_core.point.domain.model.enums.PointAccountType
import java.math.BigDecimal

data class PointRequest(
    val userSeq: Long,
    val pointAccountType: PointAccountType,
    val externalTxId: String,
    val amount: BigDecimal,
    val originalTransactionId: Long? = null,
)
