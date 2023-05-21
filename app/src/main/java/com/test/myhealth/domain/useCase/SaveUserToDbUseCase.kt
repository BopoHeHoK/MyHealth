package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.User

class SaveUserToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(user: User) {
        return userRepository.saveUserToDb(user = user)
    }
}