package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository

class SetUserIdToSharedPrefsUseCase(private val userRepository: UserRepository) {

    fun execute(id: Long) {
        return userRepository.setUserIdSharedPreferences(id)
    }
}