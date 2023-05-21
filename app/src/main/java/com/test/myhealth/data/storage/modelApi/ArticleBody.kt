package com.test.myhealth.data.storage.modelApi

data class ArticleBody(
    val id: Long,
    val title: String,
    val content: String,
    val img: String,
    val favorites: Int,
    val likes: Int,
    val ratingBody: List<RatingBody>,
)