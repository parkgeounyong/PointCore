package io.github.parkgeounyong.point_core.point.domain.model

import io.github.parkgeounyong.point_core.point.domain.model.enums.PointAccountType
import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
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

    fun earn(amount: BigDecimal, externalTxId: String): PointTransaction {
        if (amount <= BigDecimal.ZERO) throw IllegalArgumentException("적립 금액은 0보다 커야 합니다.")

        this.balance = this.balance.add(amount)
        this.version += 1
        this.updDate = Instant.now()

        return PointTransaction.create(
            externalTxId = externalTxId,
            pointAccount = this,
            type = PointTransactionType.SAVE,
            amount = amount,
            balanceAfter = this.balance,
        )
    }

    fun use(amount: BigDecimal, externalTxId: String): PointTransaction {
        if (amount <= BigDecimal.ZERO) throw IllegalArgumentException("차감 금액은 0보다 커야 합니다.")

        if (this.balance < amount) {
            throw RuntimeException("잔액이 부족합니다. 현재 잔액: ${this.balance}")
        }

        this.balance = this.balance.subtract(amount)
        this.version += 1
        this.updDate = Instant.now()

        return PointTransaction.create(
            externalTxId = externalTxId,
            pointAccount = this,
            type = PointTransactionType.USE,
            amount = amount,
            balanceAfter = this.balance,
        )
    }

    fun refund(
        amountToRefund: BigDecimal,
        externalTxId: String,
        originalTransaction: PointTransaction
    ): PointTransaction {
        if (amountToRefund <= BigDecimal.ZERO) throw IllegalArgumentException("환불 금액은 0보다 커야 합니다.")

        if (amountToRefund > originalTransaction.amount) {
            throw IllegalArgumentException("환불 금액이 원거래 금액보다 클 수 없습니다.")
        }

        if (originalTransaction.type == PointTransactionType.USE && this.balance < amountToRefund) {
            throw RuntimeException("환불할 잔액이 부족합니다.")
        }

        val newBalance = when (originalTransaction.type) {
            PointTransactionType.SAVE -> this.balance.subtract(amountToRefund)
            PointTransactionType.USE -> this.balance.add(amountToRefund)
            else -> throw IllegalArgumentException("환불할 수 없는 거래 타입입니다.")
        }

        this.balance = newBalance
        this.version += 1
        this.updDate = Instant.now()

        return PointTransaction.create(
            externalTxId = externalTxId,
            pointAccount = this,
            type = PointTransactionType.REFUND,
            amount = amountToRefund,
            balanceAfter = this.balance,
            originalTransactionSeqId = originalTransaction.id
        )
    }
}