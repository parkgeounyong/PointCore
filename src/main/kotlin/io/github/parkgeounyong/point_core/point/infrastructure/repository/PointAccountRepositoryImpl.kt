package io.github.parkgeounyong.point_core.point.infrastructure.repository

import io.github.parkgeounyong.point_core.point.domain.repository.PointAccountRepository
import org.springframework.stereotype.Repository

@Repository
class PointAccountRepositoryImpl(
    private val pointAccountJpaRepository: PointAccountJpaRepository
) : PointAccountRepository {

}