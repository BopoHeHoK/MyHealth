package com.test.myhealth.data.storage.modelApi

data class MentalConditionBody(
    val id: Long,
    val date: String?,
    val quality: Int?,
    val mentalInfo: List<MentalInfoBody?>,
    val userId: Long,
)