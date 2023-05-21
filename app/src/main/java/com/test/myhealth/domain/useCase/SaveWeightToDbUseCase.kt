package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Weight

class SaveWeightToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(weight: Weight) {
        return userRepository.saveWeightToDb(weight = weight)
    }
}