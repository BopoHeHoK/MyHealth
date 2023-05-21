package com.test.myhealth.data.storage.modelApi

data class RatingBody(
    val id: Long,
    val isLike: Boolean,
    val articleId: Long,
    val userId: Long,
)