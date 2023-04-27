package todo.server.domain.user.exception

import todo.server.global.exception.ErrorCode
import todo.server.global.exception.InvalidValueException

class UserSignInException(message: String): InvalidValueException(
    message, ErrorCode.LOGIN_INPUT_INVALID
)