package com.test.myhealth.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_articles",
    foreignKeys = [
        ForeignKey(
            entity = UserFavoriteArticlesEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_favorite_articles_id"]
        ),
        ForeignKey(
            entity = ArticleEntity::class,
            parentColumns = ["id"],
            childColumns = ["article_id"]
        )
    ]
)
data class FavoriteArticlesEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "user_favorite_articles_id")
    val userFavoriteArticlesId: Long,
    @ColumnInfo(name = "article_id")
    val articleId: Long,
)