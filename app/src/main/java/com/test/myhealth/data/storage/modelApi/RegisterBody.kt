package com.test.myhealth.data.storage.modelApi

data class RegisterBody(
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String
)