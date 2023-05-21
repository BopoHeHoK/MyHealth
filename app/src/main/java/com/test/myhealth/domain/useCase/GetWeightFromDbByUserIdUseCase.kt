package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Weight

class GetWeightFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): Weight {
        return userRepository.getWeightFromDb(userId = userId)
    }
}