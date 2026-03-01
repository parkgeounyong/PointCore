package io.github.parkgeounyong.point_core.point.infrastructure.mapper

import io.github.parkgeounyong.point_core.point.domain.model.PointAccount
import io.github.parkgeounyong.point_core.point.domain.model.enums.PointAccountType
import io.github.parkgeounyong.point_core.point.infrastructure.entity.DataPointAccount

object PointAccountEntityMapper {
    fun PointAccount.toEntity(): DataPointAccount {
        return DataPointAccount(
            id = this.id,
            userSeq = this.userSeq,
            type = this.type.name,
            entDate = this.entDate,
            balance = this.balance,
            version = this.version,
            updDate = this.updDate,
        )
    }

    fun DataPointAccount.toDomain(): PointAccount {
        return PointAccount(
            id = this.id,
            userSeq = this.userSeq,
            type = PointAccountType.valueOf(this.type),
            entDate = this.entDate,
            balance = this.balance,
            version = this.version,
            updDate = this.updDate,
        )
    }
}