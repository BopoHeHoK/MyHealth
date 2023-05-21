package com.test.myhealth.data.storage.modelApi

data class UserParameterBody(
    val id: Long,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val waist: Int?,
    val userId: Long,
    val genderId: Long?,
)