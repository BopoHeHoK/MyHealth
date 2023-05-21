package com.test.myhealth.data.storage.modelApi

data class RegisterBody(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String
)