package todo.server.domain.user.exception

import todo.server.global.exception.EntityNotFoundException
import todo.server.global.exception.ErrorCode

class UserNotFoundException(): EntityNotFoundException(
    message = ErrorCode.NOT_FOUND_MEMBER.message
)