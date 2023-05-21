package com.test.myhealth.domain.model

data class Weight(
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