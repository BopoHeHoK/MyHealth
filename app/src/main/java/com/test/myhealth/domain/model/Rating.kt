package com.test.myhealth.domain.model

data class Rating(
    val id: Long,
    val isLike: Boolean,
    val userId: Long,
    val articleId: Long,
)