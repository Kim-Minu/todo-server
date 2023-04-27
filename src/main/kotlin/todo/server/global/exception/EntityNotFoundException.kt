package todo.server.global.exception

open class EntityNotFoundException(message: String?) : BusinessException(message, ErrorCode.ENTITY_NOT_FOUND)