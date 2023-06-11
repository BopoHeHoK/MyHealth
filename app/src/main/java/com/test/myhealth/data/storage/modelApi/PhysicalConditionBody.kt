package com.test.myhealth.data.storage.modelApi

data class PhysicalConditionBody(
    val id: Long,
    val date: String?,
    val quality: Int?,
    val physicalInfo: List<PhysicalInfoBody>,
    val userId: Long,
)