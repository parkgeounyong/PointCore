package io.github.parkgeounyong.point_core.point.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "data_point_account")
class DataPointAccount(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_point_account_id_gen")
    @SequenceGenerator(name = "data_point_account_id_gen", sequenceName = "data_point_account_seq", allocationSize = 1)
    @Column(name = "seq_id", nullable = false)
    var id: Long? = null,

    @Column(name = "user_seq_id", nullable = false)
    var userSeq: Long,

    @Column(name = "type", nullable = false, length = 20)
    var type: String,

    @ColumnDefault("0")
    @Column(name = "balance", nullable = false, precision = 20, scale = 2)
    var balance: BigDecimal,

    @Version
    @Column(name = "version", nullable = false)
    var version: Long = 0,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ent_date", nullable = false)
    var entDate: Instant,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "upd_date", nullable = false)
    var updDate: Instant,
)