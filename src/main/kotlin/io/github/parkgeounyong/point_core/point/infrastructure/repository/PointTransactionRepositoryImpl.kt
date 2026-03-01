package io.github.parkgeounyong.point_core.point.infrastructure.repository

import io.github.parkgeounyong.point_core.point.domain.model.PointTransaction
import io.github.parkgeounyong.point_core.point.domain.repository.PointTransactionRepository
import io.github.parkgeounyong.point_core.point.infrastructure.mapper.PointTransactionEntityMapper.toDomain
import io.github.parkgeounyong.point_core.point.infrastructure.mapper.PointTransactionEntityMapper.toEntity
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class PointTransactionRepositoryImpl(
    private val pointTransactionJpaRepository: PointTransactionJpaRepository,
    private val entityManager: EntityManager
) : PointTransactionRepository {
    override fun findBySeqId(seqId: Long): PointTransaction? {
        return pointTransactionJpaRepository.findById(seqId).getOrNull()?.toDomain()
    }
    override fun save(pointTransaction: PointTransaction): PointTransaction {
        val entity = pointTransaction.toEntity()
        entity.pointAccount = entityManager.merge(entity.pointAccount)
        return pointTransactionJpaRepository.save(entity).toDomain()
    }
}