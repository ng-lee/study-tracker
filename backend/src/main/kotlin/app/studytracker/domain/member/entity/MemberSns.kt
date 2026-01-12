package app.studytracker.domain.member.entity

import app.studytracker.domain.common.entity.BaseEntity
import app.studytracker.global.auth.constant.ProviderType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class MemberSns(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    var member: Member,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var provider: ProviderType,

    @Column(nullable = false)
    var providerId: String
) : BaseEntity()