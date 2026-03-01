package io.github.parkgeounyong.point_core.point.domain.model

import io.github.parkgeounyong.point_core.point.domain.model.enums.PointAccountType
import java.math.BigDecimal
import java.time.Instant

class PointAccount(
    val id: Long? = null,
    val userSeq: Long,
    val type: PointAccountType,
    val entDate: Instant,
    balance: BigDecimal,
    version: Long,
    updDate: Instant,
) {
    var balance: BigDecimal = balance
        private set
    var version: Long = version
        private set
    var updDate: Instant = updDate
        private set
}