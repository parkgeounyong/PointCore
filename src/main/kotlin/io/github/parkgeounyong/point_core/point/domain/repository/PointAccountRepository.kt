package io.github.parkgeounyong.point_core.point.domain.repository

import io.github.parkgeounyong.point_core.point.domain.model.PointAccount

interface PointAccountRepository {
    fun save(pointAccount: PointAccount): PointAccount
    fun findByUserSeq(userSeq: Long): PointAccount?
}