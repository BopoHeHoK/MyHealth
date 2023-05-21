package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Water

class GetWaterFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): Water {
        return userRepository.getWaterFromDb(userId = userId)
    }
}