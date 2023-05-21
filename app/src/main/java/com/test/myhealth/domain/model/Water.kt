package com.test.myhealth.domain.model

data class Water(
    val id: Long,
    val mode: Boolean,
    val periodicity: Int,
    val userId: Long,
)