package com.test.myhealth.data.storage.modelApi

data class MedicineInfoTimeBody(
    val id: Long,
    val mode: Boolean,
    val time: String?,
    val medicineInfoId: Long,
)