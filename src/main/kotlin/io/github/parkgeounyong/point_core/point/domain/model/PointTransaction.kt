package io.github.parkgeounyong.point_core.point.domain.model

import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
import java.math.BigDecimal
import java.time.Instant

class PointTransaction(
    var id: Long? = null,
    var externalTxId: String,
    var pointAccount: PointAccount,
    var type: PointTransactionType,
    var entDate: Instant,
    amount: BigDecimal,
    balanceAfter: BigDecimal,
) {
    var amount: BigDecimal = amount
        private set
    var balanceAfter: BigDecimal = balanceAfter
        private set
}