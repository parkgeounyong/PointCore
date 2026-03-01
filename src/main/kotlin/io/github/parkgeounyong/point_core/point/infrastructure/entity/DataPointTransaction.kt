package io.github.parkgeounyong.point_core.point.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "data_point_transaction")
class DataPointTransaction(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_point_transaction_id_gen")
    @SequenceGenerator(
        name = "data_point_transaction_id_gen",
        sequenceName = "data_point_transaction_seq",
        allocationSize = 1
    )
    @Column(name = "seq_id", nullable = false)
    var id: Long? = null,

    @Column(name = "external_tx_id", nullable = false, length = 100)
    var externalTxId: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_account_seq_id", nullable = false)
    var pointAccount: DataPointAccount,

    @Column(name = "type", nullable = false, length = 20)
    var type: String,

    @Column(name = "amount", nullable = false, precision = 20, scale = 2)
    var amount: BigDecimal,

    @Column(name = "balance_after", nullable = false, precision = 20, scale = 2)
    var balanceAfter: BigDecimal,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ent_date", nullable = false)
    var entDate: Instant,
)