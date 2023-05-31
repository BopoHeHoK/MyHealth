package com.test.myhealth.domain.data.repository

interface UserStorage {

    fun setUserId(id: Long)

    fun getUserId(): Long

    fun setArticleId(id: Long)

    fun getArticleId(): Long
}