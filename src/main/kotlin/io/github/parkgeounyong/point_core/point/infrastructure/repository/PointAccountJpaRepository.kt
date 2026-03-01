package io.github.parkgeounyong.point_core.point.infrastructure.repository

import io.github.parkgeounyong.point_core.point.infrastructure.entity.DataPointAccount
import org.springframework.data.jpa.repository.JpaRepository

interface PointAccountJpaRepository : JpaRepository<DataPointAccount, Long> {
    fun findByUserSeq(userSeq: Long):DataPointAccount?
}