package com.test.myhealth.domain.model

data class PhysicalInfo(
    val id: Long,
    val note: String?,
    val physicalConditionId: Long,
)
