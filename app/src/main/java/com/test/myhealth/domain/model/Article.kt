package com.test.myhealth.domain.model

data class Article(
    val id: Long,
    val title: String?,
    val content: String?,
    val img: String?,
    val favorites: Long?,
    val likes: Long?
)