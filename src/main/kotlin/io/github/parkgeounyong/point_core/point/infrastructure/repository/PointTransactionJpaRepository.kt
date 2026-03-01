package io.github.parkgeounyong.point_core.point.infrastructure.repository

import io.github.parkgeounyong.point_core.point.infrastructure.entity.DataPointTransaction
import org.springframework.data.jpa.repository.JpaRepository

interface PointTransactionJpaRepository : JpaRepository<DataPointTransaction, Long> {
}