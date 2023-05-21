package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Rating

class GetRatingsFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<Rating> {
        return userRepository.getRatingsFromDb(userId = userId)
    }
}