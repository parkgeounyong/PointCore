package io.github.parkgeounyong.point_core.point.infrastructure.mapper

import io.github.parkgeounyong.point_core.point.domain.model.PointTransaction
import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
import io.github.parkgeounyong.point_core.point.infrastructure.entity.DataPointTransaction
import io.github.parkgeounyong.point_core.point.infrastructure.mapper.PointAccountEntityMapper.toDomain
import io.github.parkgeounyong.point_core.point.infrastructure.mapper.PointAccountEntityMapper.toEntity

object PointTransactionEntityMapper {
    fun PointTransaction.toEntity(): DataPointTransaction {
        return DataPointTransaction(
            id = this.id,
            externalTxId = this.externalTxId,
            pointAccount = this.pointAccount.toEntity(),
            type = this.type.name,
            entDate = this.entDate,
            amount = this.amount,
            balanceAfter = this.balanceAfter,
        )
    }

    fun DataPointTransaction.toDomain(): PointTransaction {
        return PointTransaction(
            id = this.id,
            externalTxId = this.externalTxId,
            pointAccount = this.pointAccount.toDomain(),
            type = PointTransactionType.valueOf(this.type),
            entDate = this.entDate,
            amount = this.amount,
            balanceAfter = this.balanceAfter,
        )
    }
}