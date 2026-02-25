package io.github.parkgeounyong.point_core.user.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "data_user")
class DataUser(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_user_id_gen")
    @SequenceGenerator(name = "data_user_id_gen", sequenceName = "data_user_seq", allocationSize = 1)
    @Column(name = "seq_id", nullable = false)
    val id: Long,

    @Column(name = "user_id", nullable = false, length = 50)
    val userId: String,

    @Column(name = "pw", nullable = false)
    val pw: String,

    @Column(name = "name", nullable = false, length = 100)
    val name: String,

    @Column(name = "phone", nullable = false, length = 20)
    val phone: String,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ent_date", nullable = false)
    val entDate: Instant,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "upd_date", nullable = false)
    val updDate: Instant,
)