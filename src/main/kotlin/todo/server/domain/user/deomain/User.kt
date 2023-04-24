package todo.server.domain.user.deomain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(length = 50, nullable = false)
    var email: String,

    @Column(length = 100, nullable = false)
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 5, nullable = false)
    var role: Role = Role.USER,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

) {


}