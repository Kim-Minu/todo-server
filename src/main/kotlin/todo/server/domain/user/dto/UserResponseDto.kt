package todo.server.domain.user.dto

import todo.server.domain.user.domain.User

data class UserResponseDto (
    val id: Long,
    val email: String,
){
    constructor(user: User) : this(
        user.id,
        user.email
    )
}
