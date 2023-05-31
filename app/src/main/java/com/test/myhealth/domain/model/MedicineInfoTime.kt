package com.test.myhealth.domain.model

data class MedicineInfoTime(
    val id: Long,
    val mode: Boolean,
    val time: String?,
    val medicineInfoId: Long,
)
