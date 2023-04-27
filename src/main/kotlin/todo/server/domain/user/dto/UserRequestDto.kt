package todo.server.domain.user.dto

import todo.server.domain.user.domain.Role
import todo.server.domain.user.domain.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

class UserRequestDto {
}

class UserSignInRequestDto(
    @field:NotEmpty
    val id: String,

    @field:NotEmpty
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자를 사용하세요.")
    val password: String
)

class UserSignUpRequestDto(
    @field:NotEmpty
    @field:Email
    val email: String,

    @field:NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자를 사용하세요.")
    val password: String,

) {

    fun toEntity(password: String): User {
        return User(email = email,
            password = password,
            role = Role.USER
        )
    }
}
