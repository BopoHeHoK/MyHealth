package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Water

class SaveWaterToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(water: Water) {
        return userRepository.saveWaterToDb(water = water)
    }
}