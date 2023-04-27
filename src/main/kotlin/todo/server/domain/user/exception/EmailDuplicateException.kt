package todo.server.domain.user.exception

import todo.server.global.exception.ErrorCode
import todo.server.global.exception.InvalidValueException

class EmailDuplicateException(email: String) : InvalidValueException(
    email,
    ErrorCode.EMAIL_DUPLICATION
)