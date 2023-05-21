package com.test.myhealth.data.storage.modelApi

data class PressureBody(
    val id: Long,
    val mode: Boolean,
    val time1: String,
    val time1_mode: Boolean,
    val time2: String,
    val time2_mode: Boolean,
    val time3: String,
    val time3_mode: Boolean,
    val userId: Long,
)