package app.studytracker.global.auth.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

data class CustomOAuth2User(
    val idx: Long,
    val email: String,
    val userName: String,
    val extraAttributes: Map<String, Any>,
) : OAuth2User {
    override fun getAttributes(): Map<String, Any> {
        return extraAttributes
    }

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return listOf(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getName(): String {
        return idx.toString()
    }
}