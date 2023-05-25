package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository

class GetArticleIdFromSharedPrefsUseCase(private val userRepository: UserRepository) {

    fun execute(): Long {
        return userRepository.getArticleIdSharedPreferences()
    }
}