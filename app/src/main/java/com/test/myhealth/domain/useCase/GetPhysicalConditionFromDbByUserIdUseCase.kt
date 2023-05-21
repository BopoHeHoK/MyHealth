package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.PhysicalCondition

class GetPhysicalConditionFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<PhysicalCondition> {
        return userRepository.getPhysicalConditionFromDb(userId = userId)
    }
}