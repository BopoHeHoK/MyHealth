package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MentalCondition

class GetMentalConditionFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<MentalCondition> {
        return userRepository.getMentalConditionFromDb(userId = userId)
    }
}