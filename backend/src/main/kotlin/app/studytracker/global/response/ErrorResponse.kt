package app.studytracker.global.response

data class ErrorResponse(
    val success: Boolean = false,
    val errorCode: String,
    val errorMessage: String
)