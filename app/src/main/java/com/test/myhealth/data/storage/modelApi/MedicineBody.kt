package com.test.myhealth.data.storage.modelApi

data class MedicineBody(
    val id: Long,
    val mode: Boolean,
    val medicineInfo: List<MedicineInfoBody?>,
    val userId: Long,
)