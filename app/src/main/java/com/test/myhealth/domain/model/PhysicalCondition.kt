package com.test.myhealth.domain.model

data class PhysicalCondition(
    val id: Long,
    val date: String?,
    val quality: Int?,
    val userId: Long,
)
