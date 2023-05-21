package com.test.myhealth.data.storage.modelApi

data class MedicineInfoBody(
    val id: Long,
    val mode: Boolean,
    val medicine_name: String,
    val medicine_dosage: String,
    val disease_name: String,
    val start_day: String,
    val end_day: String,
    val medicineInfoTime: List<MedicineInfoTimeBody>,
    val medicineId: Long,
)