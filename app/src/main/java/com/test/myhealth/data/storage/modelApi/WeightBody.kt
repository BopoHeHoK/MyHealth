package com.test.myhealth.data.storage.modelApi

data class WeightBody(
    val id: Long,
    val mode: Boolean,
    val monday: Boolean,
    val tuesday: Boolean,
    val wednesday: Boolean,
    val thursday: Boolean,
    val friday: Boolean,
    val saturday: Boolean,
    val sunday: Boolean,
    val time: String,
    val userId: Long,
)