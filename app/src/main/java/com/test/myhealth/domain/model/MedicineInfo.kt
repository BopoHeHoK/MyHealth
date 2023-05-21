package com.test.myhealth.domain.model


data class MedicineInfo(
    val id: Long,
    val mode: Boolean,
    val medicine_name: String?,
    val medicine_dosage: String?,
    val disease_name: String?,
    val start_day: String?,
    val end_day: String?,
    val medicineId: Long,
)
