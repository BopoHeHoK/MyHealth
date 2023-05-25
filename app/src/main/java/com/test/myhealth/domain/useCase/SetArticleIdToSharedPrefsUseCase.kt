package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository

class SetArticleIdToSharedPrefsUseCase(private val userRepository: UserRepository) {

    fun execute(id: Long) {
        return userRepository.setArticleIdSharedPreferences(id = id)
    }
}