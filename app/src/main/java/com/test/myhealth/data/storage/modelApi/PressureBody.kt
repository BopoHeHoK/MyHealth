package com.test.myhealth.data.storage.modelApi

data class PressureBody(
    val id: Long,
    val mode: Boolean,
    val time1: String,
    val time1Mode: Boolean,
    val time2: String,
    val time2Mode: Boolean,
    val time3: String,
    val time3Mode: Boolean,
    val userId: Long,
)