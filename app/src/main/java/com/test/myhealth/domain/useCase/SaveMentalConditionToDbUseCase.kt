package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MentalCondition

class SaveMentalConditionToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(mentalCondition: MentalCondition) {
        return userRepository.saveMentalConditionToDb(mentalCondition = mentalCondition)
    }
}