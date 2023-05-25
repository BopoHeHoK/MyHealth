package com.test.myhealth.data.storage.modelApi

data class UserBodyToSave(
    val id: Long,
    val email: String?,
    val phoneNumber: String?,
    val firstName: String?,
    val lastName: String?,
    val roleId: Long
)