package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "water",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        )
    ]
)
data class WaterEntity(
    @PrimaryKey
    val id: Long,
    val mode: Boolean,
    val periodicity: Int,
    @ColumnInfo(name = "user_id")
    val userId: Long,
)