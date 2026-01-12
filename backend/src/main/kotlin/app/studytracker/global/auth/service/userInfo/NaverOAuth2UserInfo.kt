package app.studytracker.global.auth.service.userInfo

class NaverOAuth2UserInfo(
    val attributes: Map<String, Any>
) : OAuth2UserInfo() {
    val response = attributes["response"] as? Map<String, Any>

    override fun getId(): String? {
        return response?.get("id") as? String
    }

    override fun getEmail(): String? {
        return response?.get("email") as? String
    }

    override fun getName(): String? {
        return response?.get("name") as? String
    }
}