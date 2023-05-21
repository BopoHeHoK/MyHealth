package com.test.myhealth.data.storage.modelDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roles")
data class RoleEntity (
    @PrimaryKey
    val id: Long,
    val role: String?,
)