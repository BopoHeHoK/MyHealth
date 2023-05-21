package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.UserParameter

class GetUserParameterFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): UserParameter {
        return userRepository.getUserParameterFromDb(userId = userId)
    }
}