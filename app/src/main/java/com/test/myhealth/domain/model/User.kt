package com.test.myhealth.domain.model

data class User(
    val id: Long,
    val email: String?,
    val phoneNumber: String?,
    val firstName: String?,
    val lastName: String?,
    val roleId: Long,
)
