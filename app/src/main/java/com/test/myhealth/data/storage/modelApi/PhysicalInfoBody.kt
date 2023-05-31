package com.test.myhealth.data.storage.modelApi

data class PhysicalInfoBody(
    val id: Long,
    val note: String?,
    val physicalConditionId: Long,
)