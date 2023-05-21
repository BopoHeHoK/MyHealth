package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "dream_info",
    foreignKeys = [
        ForeignKey(
            entity = DreamEntity::class,
            parentColumns = ["id"],
            childColumns = ["dream_id"]
        )
    ]
)
data class DreamInfoEntity(
    @PrimaryKey
    val id: Long,
    val note: String?,
    @ColumnInfo(name = "dream_id")
    val dreamId: Long,
)
