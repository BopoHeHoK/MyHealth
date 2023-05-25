package com.test.myhealth.domain.data.repository

import com.test.myhealth.data.repository.SharedPreferences

interface UserStorage {

    fun setUserId(id: Long)

    fun getUserId(): Long

    fun setArticleId(id: Long)

    fun getArticleId(): Long
}