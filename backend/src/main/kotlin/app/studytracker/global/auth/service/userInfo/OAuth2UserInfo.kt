package app.studytracker.global.auth.service.userInfo

abstract class OAuth2UserInfo {
    abstract fun getId(): String?
    abstract fun getEmail(): String?
    abstract fun getName(): String?
}