package com.test.myhealth.domain.model

data class Dream(
    val id: Long,
    val date: String?,
    val quality: Int?,
    val userId: Long,
)
