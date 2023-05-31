package com.test.myhealth.data.storage.modelApi

data class MentalInfoBody(
    val id: Long,
    val note: String?,
    val mentalConditionId: Long,
)