package app.studytracker.global.auth.constant

import app.studytracker.global.error.ErrorCode
import app.studytracker.global.exception.BusinessException

enum class ProviderType {
    GOOGLE,
    NAVER
    ;

    companion object {
        fun getProvider(registrationId: String): ProviderType {
            return values().find { it.name.equals(registrationId.uppercase()) }
                ?: throw BusinessException(ErrorCode.UNSUPPORTED_PROVIDER)
        }
    }
}