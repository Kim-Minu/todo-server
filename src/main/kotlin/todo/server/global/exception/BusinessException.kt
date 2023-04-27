package todo.server.global.exception

open class BusinessException : RuntimeException {
    var errorCode: ErrorCode

    constructor(message: String?, errorCode: ErrorCode) : super(message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode) : super(errorCode.message) {
        this.errorCode = errorCode
    }
}