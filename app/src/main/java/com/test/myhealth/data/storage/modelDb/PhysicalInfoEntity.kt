package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "physical_info",
    foreignKeys = [
        ForeignKey(
            entity = PhysicalConditionEntity::class,
            parentColumns = ["id"],
            childColumns = ["physical_condition_id"]
        )
    ])
data class PhysicalInfoEntity(
    @PrimaryKey
    val id: Long,
    val note: String?,
    @ColumnInfo(name = "physical_condition_id")
    val physicalConditionId: Long,
)
