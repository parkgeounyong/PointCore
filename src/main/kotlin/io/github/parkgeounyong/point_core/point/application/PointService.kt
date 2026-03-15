package io.github.parkgeounyong.point_core.point.application

import io.github.parkgeounyong.point_core.point.application.command.PointCommand
import io.github.parkgeounyong.point_core.point.domain.model.PointAccount
import io.github.parkgeounyong.point_core.point.domain.model.enums.PointTransactionType
import io.github.parkgeounyong.point_core.point.domain.repository.PointAccountRepository
import io.github.parkgeounyong.point_core.point.domain.repository.PointTransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PointService(
    private val pointAccountRepository: PointAccountRepository,
    private val pointTransactionRepository: PointTransactionRepository
) {
    @Transactional
    fun pointProcess(pointCommand: PointCommand) {
        val pointAccount = pointAccountRepository.findByUserSeq(pointCommand.userSeq) ?: pointAccountRepository.save(
            PointAccount.create(pointCommand.userSeq, pointCommand.pointAccountType)
        )

        val pointTransaction = when (pointCommand.pointTransactionType) {
            PointTransactionType.USE -> pointAccount.use(pointCommand.amount, pointCommand.externalTxId)
            PointTransactionType.EARN -> pointAccount.earn(pointCommand.amount, pointCommand.externalTxId)
            PointTransactionType.REFUND -> {
                val originalTransaction = pointTransactionRepository.findBySeqId(pointCommand.originalTransactionId!!)
                pointAccount.refund(pointCommand.amount, pointCommand.externalTxId, originalTransaction!!)
            }
        }
        pointAccountRepository.save(pointTransaction.pointAccount)
        pointTransactionRepository.save(pointTransaction)
    }
}