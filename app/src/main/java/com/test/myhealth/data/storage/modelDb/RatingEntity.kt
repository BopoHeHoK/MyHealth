package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ratings",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        ),
        ForeignKey(
            entity = ArticleEntity::class,
            parentColumns = ["id"],
            childColumns = ["article_id"]
        )
    ]
)
data class RatingEntity(
    @PrimaryKey
    val id: Long,
    val isLike: Boolean,
    @ColumnInfo(name = "user_id")
    val userId: Long,
    @ColumnInfo(name = "article_id")
    val articleId: Long,
)