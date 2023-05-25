package com.test.myhealth.data.storage.modelApi

data class MedicineInfoBody(
    val id: Long,
    val mode: Boolean,
    val medicineName: String,
    val medicineDosage: String,
    val diseaseName: String,
    val startDay: String,
    val endDay: String,
    val medicineInfoTime: List<MedicineInfoTimeBody>,
    val medicineId: Long,
)