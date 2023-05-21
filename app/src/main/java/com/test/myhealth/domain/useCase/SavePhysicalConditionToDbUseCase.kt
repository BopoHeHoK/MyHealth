package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.PhysicalCondition

class SavePhysicalConditionToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(physicalCondition: PhysicalCondition) {
        return userRepository.savePhysicalConditionToDb(physicalCondition = physicalCondition)
    }
}