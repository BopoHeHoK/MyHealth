package com.test.myhealth.data.storage.modelDb

import androidx.room.*

@Entity(
    tableName = "medicine_info_times",
    foreignKeys = [
        ForeignKey(
            entity = MedicineInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["medicine_info_id"]
        )
    ]
)
data class MedicineInfoTimeEntity(
    @PrimaryKey
    val id: Long,
    val mode: Boolean,
    val time: String?,
    @ColumnInfo(name = "medicine_info_id")
    val medicineInfoId: Long,
)
