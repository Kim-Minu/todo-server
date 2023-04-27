package todo.server.domain.user.dto

import todo.server.domain.user.domain.User

data class UserSignInResponseDto(
    val id: Long,
    val email: String,
    val token: String,
) {
    constructor(user: User, token: String) : this(
        user.id,
        user.email,
        token
    )
}


