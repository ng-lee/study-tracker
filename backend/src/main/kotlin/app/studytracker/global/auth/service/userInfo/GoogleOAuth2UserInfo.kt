package app.studytracker.global.auth.service.userInfo

class GoogleOAuth2UserInfo(
    val attributes: Map<String, Any>
) : OAuth2UserInfo() {
    override fun getId(): String? {
        return attributes?.get("sub") as? String
    }

    override fun getEmail(): String? {
        return attributes?.get("email") as? String
    }

    override fun getName(): String? {
        return attributes?.get("name") as? String
    }
}