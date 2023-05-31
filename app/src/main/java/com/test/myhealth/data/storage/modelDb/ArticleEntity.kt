package com.test.myhealth.data.storage.modelDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val id: Long,
    val title: String?,
    val content: String?,
    val img: String?,
    val favorites: Long?,
    val likes: Long?,
)