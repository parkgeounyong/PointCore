package io.github.parkgeounyong.point_core.point.domain.repository

import io.github.parkgeounyong.point_core.point.domain.model.PointTransaction

interface PointTransactionRepository {
    fun save(pointTransaction: PointTransaction): PointTransaction
    fun findBySeqId(seqId: Long): PointTransaction?
}