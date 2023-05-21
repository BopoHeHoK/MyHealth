package com.test.myhealth.domain.model

data class UserParameter(
    val id: Long,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val waist: Int?,
    val userId: Long,
    val genderId: Long?,
)