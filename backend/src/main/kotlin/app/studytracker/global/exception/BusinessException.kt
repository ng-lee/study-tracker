package app.studytracker.global.exception

import app.studytracker.global.error.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)