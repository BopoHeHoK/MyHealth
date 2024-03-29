package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.User

class GetUserFromDbByIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): User {
        return userRepository.getUserFromDb(userId = userId)
    }
}