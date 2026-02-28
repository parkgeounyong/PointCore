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
    var id: Long? = null,

    @Column(name = "user_id", nullable = false, length = 50)
    var userId: String,

    @Column(name = "pw", nullable = false)
    var pw: String,

    @Column(name = "name", nullable = false, length = 100)
    var name: String,

    @Column(name = "phone", nullable = false, length = 20)
    var phone: String,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ent_date", nullable = false)
    var entDate: Instant,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "upd_date", nullable = false)
    var updDate: Instant,
)