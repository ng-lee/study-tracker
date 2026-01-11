package app.studytracker.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val httpStatus: HttpStatus,
    val code: String,
    val message: String
) {
    UNSUPPORTED_PROVIDER(HttpStatus.BAD_REQUEST, "A001","지원하지 않는 OAuth 프로바이더입니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 오류가 발생했습니다."),
}