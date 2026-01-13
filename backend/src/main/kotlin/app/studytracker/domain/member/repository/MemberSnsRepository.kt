package app.studytracker.domain.member.repository

import app.studytracker.domain.member.entity.MemberSns
import app.studytracker.global.auth.constant.ProviderType
import org.springframework.data.jpa.repository.JpaRepository

interface MemberSnsRepository: JpaRepository<MemberSns, Long> {
    fun findByProviderAndProviderId(provider: ProviderType, providerId: String): MemberSns?
}