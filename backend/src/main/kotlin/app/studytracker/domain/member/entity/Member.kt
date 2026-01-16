package app.studytracker.domain.member.entity

import app.studytracker.domain.common.entity.BaseEntity
import app.studytracker.global.auth.constant.ProviderType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long = 0L,

    @Column(nullable = false, length = 30)
    var name: String,

    @Column(nullable = false)
    var email: String
) : BaseEntity()