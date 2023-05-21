package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Food

class GetFoodFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): Food {
        return userRepository.getFoodFromDb(userId = userId)
    }
}