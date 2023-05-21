package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class,
            parentColumns = ["id"],
            childColumns = ["role_id"]
        )
    ]
)
data class UserEntity(
    @PrimaryKey
    val id: Long,
    val email: String?,
    val phoneNumber: String?,
    val firstName: String?,
    val lastName: String?,
    @ColumnInfo(name = "role_id")
    val roleId: Long,
)
