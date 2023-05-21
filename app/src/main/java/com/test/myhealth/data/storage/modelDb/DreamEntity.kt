package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "dreams",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        )
    ]
)
data class DreamEntity(
    @PrimaryKey
    val id: Long,
    val date: String,
    val quality: Int,
    @ColumnInfo(name = "user_id")
    val userId: Long,
)
