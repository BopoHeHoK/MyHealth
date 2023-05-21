package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_parameters",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        ),
        ForeignKey(
            entity = GenderEntity::class,
            parentColumns = ["id"],
            childColumns = ["gender_id"]
        )
    ]
)
data class UserParameterEntity(
    @PrimaryKey
    val id: Long,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val waist: Int?,
    @ColumnInfo(name = "user_id")
    val userId: Long,
    @ColumnInfo(name = "gender_id")
    val genderId: Long?,
)