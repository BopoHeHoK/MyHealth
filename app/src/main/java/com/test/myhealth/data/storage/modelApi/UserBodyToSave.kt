package com.test.myhealth.data.storage.modelApi

data class UserBodyToSave(
    val id: Long,
    val email: String?,
    val phone_number: String?,
    val first_name: String?,
    val last_name: String?,
    val roleId: Long
)