package app.studytracker.global.handler

import app.studytracker.global.error.ErrorCode
import app.studytracker.global.exception.BusinessException
import app.studytracker.global.response.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorCode = e.errorCode
        val errorResponse = ErrorResponse(errorCode = errorCode.code, errorMessage = errorCode.message)
        return ResponseEntity.status(errorCode.httpStatus).body(errorResponse);
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.INTERNAL_SERVER_ERROR
        val errorResponse = ErrorResponse(errorCode = errorCode.code, errorMessage = errorCode.message)
        return ResponseEntity.status(errorCode.httpStatus).body(errorResponse)
    }
}