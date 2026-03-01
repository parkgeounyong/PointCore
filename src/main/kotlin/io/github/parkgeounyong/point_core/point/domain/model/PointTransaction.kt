package io.github.parkgeounyong.point_core.point.domain.model

import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
import io.github.parkgeounyong.point_core.user.domain.user.model.User
import java.math.BigDecimal
import java.time.Instant

class PointTransaction(
    val id: Long? = null,
    val externalTxId: String,
    val pointAccount: PointAccount,
    val type: PointTransactionType,
    val entDate: Instant,
    val originalTransactionSeqId: Long? = null,
    amount: BigDecimal,
    balanceAfter: BigDecimal,
) {
    var amount: BigDecimal = amount
        private set
    var balanceAfter: BigDecimal = balanceAfter
        private set

    companion object {
        fun create(
            externalTxId: String,
            pointAccount: PointAccount,
            type: PointTransactionType,
            amount: BigDecimal,
            balanceAfter: BigDecimal,
            originalTransactionSeqId: Long? = null
        ): PointTransaction {
            return PointTransaction(
                externalTxId = externalTxId,
                pointAccount = pointAccount,
                type = type,
                amount = amount,
                balanceAfter = balanceAfter,
                entDate = Instant.now(),
                originalTransactionSeqId = originalTransactionSeqId
            )
        }
    }
}