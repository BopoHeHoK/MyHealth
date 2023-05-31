package com.test.myhealth.data.storage.modelApi

data class ArticleBody(
    val id: Long,
    val title: String?,
    val content: String?,
    val img: String?,
    val favorites: Long,
    val likes: Long,
    val ratingBody: List<RatingBody?>,
)