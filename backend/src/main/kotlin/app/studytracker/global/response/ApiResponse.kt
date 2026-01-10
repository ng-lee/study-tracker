package app.studytracker.global.response

data class ApiResponse<T>(
    val success: Boolean = true,
    val data: T
)
