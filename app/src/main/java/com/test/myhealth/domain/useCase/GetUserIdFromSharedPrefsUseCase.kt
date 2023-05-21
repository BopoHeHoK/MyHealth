package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository

class GetUserIdFromSharedPrefsUseCase(private val userRepository: UserRepository) {

    fun execute(): Long {
        return userRepository.getUserIdSharedPreferences()
    }
}