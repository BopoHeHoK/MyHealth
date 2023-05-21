package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "mental_info",
    foreignKeys = [
        ForeignKey(
            entity = MentalConditionEntity::class,
            parentColumns = ["id"],
            childColumns = ["mental_condition_id"]
        )
    ]
)
data class MentalInfoEntity(
    @PrimaryKey
    val id: Long,
    val note: String?,
    @ColumnInfo(name = "mental_condition_id")
    val mentalConditionId: Long,
)
