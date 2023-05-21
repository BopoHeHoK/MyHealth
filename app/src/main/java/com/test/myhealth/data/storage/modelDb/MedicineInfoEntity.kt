package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "medicine_info",
    foreignKeys = [
        ForeignKey(
            entity = MedicineEntity::class,
            parentColumns = ["id"],
            childColumns = ["medicine_id"]
        )
    ]
)
data class MedicineInfoEntity(
    @PrimaryKey
    val id: Long,
    val mode: Boolean,
    val medicine_name: String?,
    val medicine_dosage: String?,
    val disease_name: String?,
    val start_day: String?,
    val end_day: String?,
    @ColumnInfo(name = "medicine_id")
    val medicineId: Long,
)
