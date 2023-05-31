package com.test.myhealth.data.storage.modelApi

data class DreamBody(
    val id: Long,
    val date: String?,
    val quality: Int?,
    val dreamInfo: List<DreamInfoBody?>,
    val userId: Long,
)