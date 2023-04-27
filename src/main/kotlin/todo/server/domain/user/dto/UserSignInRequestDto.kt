package todo.server.domain.user.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class UserSignInRequestDto(
    @field:NotEmpty
    val id: String,

    @field:NotEmpty
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자를 사용하세요.")
    val password: String
)

