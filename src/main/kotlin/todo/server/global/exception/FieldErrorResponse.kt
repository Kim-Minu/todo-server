package todo.server.global.exception

class FieldErrorResponse (
    val field: String? = null,
    val value: String? = null,
    val reason: String? = null
)