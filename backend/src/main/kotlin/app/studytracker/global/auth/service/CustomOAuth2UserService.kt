package app.studytracker.global.auth.service

import app.studytracker.domain.member.entity.Member
import app.studytracker.domain.member.entity.MemberSns
import app.studytracker.domain.member.repository.MemberRepository
import app.studytracker.domain.member.repository.MemberSnsRepository
import app.studytracker.global.auth.constant.ProviderType
import app.studytracker.global.auth.dto.CustomOAuth2User
import app.studytracker.global.error.ErrorCode
import app.studytracker.global.exception.BusinessException
import jakarta.transaction.Transactional
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class CustomOAuth2UserService(
    val memberRepository: MemberRepository,
    val memberSnsRepository: MemberSnsRepository
) : DefaultOAuth2UserService() {

    @Transactional
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        // 유저 정보 조회
        val oAuth2User = super.loadUser(userRequest)

        // 소셜 로그인 타입
        val registrationId = userRequest.clientRegistration.registrationId
        val attributes = oAuth2User.attributes

        // 소셜 타입별 유저 정보 파싱
        val oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, attributes)
        val name = oAuth2UserInfo.getName() ?: throw BusinessException(ErrorCode.OAUTH_NAME_NOT_FOUND)
        val email = oAuth2UserInfo.getEmail() ?: throw BusinessException(ErrorCode.OAUTH_EMAIL_NOT_FOUND)
        val providerId = oAuth2UserInfo.getId() ?: throw BusinessException(ErrorCode.OAUTH_ID_NOT_FOUND)

        val member = memberRepository.findByEmail(email) ?: memberRepository.save(
            Member(
                name = name,
                email = email
            )
        )

        memberSnsRepository.findByProviderAndProviderId(registrationId, providerId) ?: memberSnsRepository.save(
            MemberSns(
                member = member,
                provider = ProviderType.getProvider(registrationId),
                providerId = providerId
            )
        )

        return CustomOAuth2User(member.id, member.email, member.name, attributes)
    }
}