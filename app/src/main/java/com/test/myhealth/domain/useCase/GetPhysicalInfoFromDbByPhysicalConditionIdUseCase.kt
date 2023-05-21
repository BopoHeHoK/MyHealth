package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.PhysicalInfo

class GetPhysicalInfoFromDbByPhysicalConditionIdUseCase(private val userRepository: UserRepository) {

    fun execute(physicalConditionId: Long): List<PhysicalInfo> {
        return userRepository.getPhysicalInfoFromDb(physicalConditionId = physicalConditionId)
    }
}