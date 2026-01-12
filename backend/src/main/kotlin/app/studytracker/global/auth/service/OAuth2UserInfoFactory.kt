package app.studytracker.global.auth.service

import app.studytracker.global.auth.service.userInfo.GoogleOAuth2UserInfo
import app.studytracker.global.auth.service.userInfo.NaverOAuth2UserInfo
import app.studytracker.global.auth.service.userInfo.OAuth2UserInfo
import app.studytracker.global.error.ErrorCode
import app.studytracker.global.exception.BusinessException

class OAuth2UserInfoFactory {
    companion object {
        fun getOAuth2UserInfo(registrationId: String, attributes: Map<String, Any>): OAuth2UserInfo {
            return when (registrationId.uppercase()) {
                "GOOGLE" -> GoogleOAuth2UserInfo(attributes = attributes)
                "NAVER" -> NaverOAuth2UserInfo(attributes = attributes)
                else -> throw BusinessException(ErrorCode.UNSUPPORTED_PROVIDER)
            }
        }
    }
}