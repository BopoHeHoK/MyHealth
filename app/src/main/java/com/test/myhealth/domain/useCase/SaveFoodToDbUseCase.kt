package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Food

class SaveFoodToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(food: Food) {
        return userRepository.saveFoodToDb(food = food)
    }
}