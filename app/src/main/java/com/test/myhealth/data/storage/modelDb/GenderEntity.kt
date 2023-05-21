package com.test.myhealth.data.storage.modelDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genders")
data class GenderEntity(
    @PrimaryKey
    val id: Long,
    val gender: String?,
)
