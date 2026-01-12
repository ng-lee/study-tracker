package app.studytracker.domain.member.repository

import app.studytracker.domain.member.entity.MemberSns
import org.springframework.data.jpa.repository.JpaRepository

interface MemberSnsRepository: JpaRepository<MemberSns, Long> {
    fun findByProviderAndProviderId(registrationId: String, providerId: String): MemberSns?
}