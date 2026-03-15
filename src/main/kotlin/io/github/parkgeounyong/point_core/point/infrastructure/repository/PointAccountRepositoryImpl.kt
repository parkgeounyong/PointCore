package io.github.parkgeounyong.point_core.point.infrastructure.repository

import io.github.parkgeounyong.point_core.point.domain.model.PointAccount
import io.github.parkgeounyong.point_core.point.domain.repository.PointAccountRepository
import io.github.parkgeounyong.point_core.point.infrastructure.mapper.PointAccountEntityMapper.toDomain
import io.github.parkgeounyong.point_core.point.infrastructure.mapper.PointAccountEntityMapper.toEntity
import org.springframework.stereotype.Repository

@Repository
class PointAccountRepositoryImpl(
    private val pointAccountJpaRepository: PointAccountJpaRepository,
) : PointAccountRepository {
    override fun save(pointAccount: PointAccount): PointAccount {
        return pointAccountJpaRepository.save(pointAccount.toEntity()).toDomain()
    }

    override fun findByUserSeq(userSeq: Long): PointAccount? {
        return pointAccountJpaRepository.findByUserSeq(userSeq)
            ?.toDomain()
    }
}