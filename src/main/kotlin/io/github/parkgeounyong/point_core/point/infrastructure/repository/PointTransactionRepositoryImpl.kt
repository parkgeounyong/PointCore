package io.github.parkgeounyong.point_core.point.infrastructure.repository

import io.github.parkgeounyong.point_core.point.domain.repository.PointTransactionRepository
import org.springframework.stereotype.Repository

@Repository
class PointTransactionRepositoryImpl(
    private val pointTransactionJpaRepository: PointTransactionJpaRepository
) : PointTransactionRepository {

}