package com.test.myhealth.domain.model

data class FavoriteArticle(
    val id: Long,
    val userFavoriteArticlesId: Long,
    val articleId: Long,
)