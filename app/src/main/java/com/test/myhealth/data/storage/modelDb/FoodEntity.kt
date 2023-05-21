package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "food",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        )
    ]
)
data class FoodEntity(
    @PrimaryKey
    val id: Long,
    val mode: Boolean,
    val time1: String,
    val time1_mode: Boolean,
    val time2: String,
    val time2_mode: Boolean,
    val time3: String,
    val time3_mode: Boolean,
    val time4: String,
    val time4_mode: Boolean,
    val time5: String,
    val time5_mode: Boolean,
    @ColumnInfo(name = "user_id")
    val userId: Long,
)